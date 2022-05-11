package com.pet.adoption.service;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.List;

import javax.mail.MessagingException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.io.source.ByteArrayOutputStream;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.pet.adoption.common.AdoStatusEnum;
import com.pet.adoption.dto.param.AdoPetParam;
import com.pet.adoption.dto.param.PdfParam;
import com.pet.adoption.model.AdoPet;
import com.pet.adoption.model.AdoPetPic;
import com.pet.adoption.model.Breeder;
import com.pet.adoption.model.Employee;
import com.pet.adoption.repository.AdoPetPicRepository;
import com.pet.adoption.repository.AdoPetRepository;
import com.pet.adoption.repository.EmployeeRepository;
import com.pet.adoption.util.MailService;
import com.pet.adoption.util.ModelMapperUtil;

@Service
public class AdoPetServiceImpl implements AdoPetService {

	@Autowired
	private AdoPetRepository adoPetRepository;

	@Autowired
	private AdoPetPicRepository adoPetPicRepository;

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private ModelMapperUtil modelMapperUtil;

	@Autowired
	private MailService mailService;

	@Value("${pdf.template.path}")
	private String pdfPath;

	@Autowired
	private ResourceLoader resourceLoader;

	@Override
	@Transactional
	public AdoPet saveAdoPet(AdoPetParam adoPet) {
		System.out.println("status" + adoPet.getAdoStatus());

		MultipartFile[] adoPetPic = adoPet.getPhotos();
		AdoPet tempPet = modelMapperUtil.map(adoPet, AdoPet.class);
		if (tempPet.getAdoStatus() == null)
			tempPet.setAdoStatus(AdoStatusEnum.CREATE);

		AdoPet adopet = adoPetRepository.save(tempPet);
		System.out.println("modelMapperUtil done");

		System.out.println("adopet NO done" + adopet.getAdoPetNo());

		if (adoPetPic != null) {
			for (MultipartFile file : adoPetPic) {
				AdoPetPic pic = new AdoPetPic();

				try {
					pic.setAdoPetPic(file.getBytes());
				} catch (IOException e) {
					e.printStackTrace();
				}
				adopet.add(pic);
			}
		}

		return adoPetRepository.save(adopet);
	}

	@Override
	@Transactional
	public AdoPet updateAdoPet(AdoPetParam adoPet) {
		if (adoPet.getDelImageList() != null)
			adoPetPicRepository.deleteAllByIdInBatch(adoPet.getDelImageList());
		return saveAdoPet(adoPet);
	}

	public void deleteAdopet(Long adoPet) {
		adoPetRepository.deleteById(adoPet);
	}

	@Override
	public AdoPet updateAdoStatus(Long adoPetNo, String adoStatus) {
		AdoPet adopet = adoPetRepository.findByAdoPetNo(adoPetNo);
		adopet.setAdoStatus(AdoStatusEnum.valueOf(adoStatus));
		return adoPetRepository.save(adopet);
	}

	@Override
	public List<AdoPet> findByAdoStatus(AdoStatusEnum adoStatus) {
		return adoPetRepository.findByAdoStatus(adoStatus);
	}

	@Override
	public List<AdoPet> findAllAdopet() {

		return adoPetRepository.findAll();
	}

	@Override
	public List<AdoPet> searchAdopet(String word) {
		return adoPetRepository.findAll(word);
	}

	@Override
	public AdoPet findByAdoPetNo(Long adoPetNo) {
		return adoPetRepository.findByAdoPetNo(adoPetNo);
	}

	@Override
	public void insertAppForm(PdfParam param) throws IOException {
		AdoPet adopet = adoPetRepository.findByAdoPetNo(param.getAdoPetNo());
		adopet.setAdoStatus(AdoStatusEnum.PROCESSING);
		Breeder breeder = adopet.getBreeder();

		if (breeder == null)
			breeder = new Breeder();

		breeder.setBreederName(param.getApplicant());
		breeder.setBreederEmail(param.getEmail());
		breeder.setBreederPhone(param.getPhone());
		adopet.setBreeder(breeder);

		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PdfWriter writer = new PdfWriter(byteArrayOutputStream);

		PdfDocument pdfDoc;

		File importPdf = new File(resourceLoader.getResource(pdfPath).getFile(), "PetfectMatchApply.pdf");
		File importFontPath = new File(resourceLoader.getResource(pdfPath).getFile(), "simsun.ttc");

		pdfDoc = new PdfDocument(new PdfReader(importPdf), writer);
		Document doc = new Document(pdfDoc);
		PdfFont sysFont = PdfFontFactory.createFont(importFontPath + ",1", PdfEncodings.IDENTITY_H, false);

		Paragraph name = new Paragraph(breeder.getBreederName());
		name.setFixedPosition(185, 753, 100);
		name.setFont(sysFont);
		name.setFontSize(13);
		doc.add(name);

		Paragraph petNamePDF = new Paragraph(adopet.getPetName());
		petNamePDF.setFixedPosition(130, 695, 200);
		petNamePDF.setFont(sysFont);
		petNamePDF.setFontSize(13);
		doc.add(petNamePDF);

		Paragraph sex = new Paragraph(adopet.getPetSex().toString().equals("FEMALE") ? "母" : "公");
		sex.setFixedPosition(130, 668, 100);
		sex.setFont(sysFont);
		sex.setFontSize(13);
		doc.add(sex);

		Paragraph weight = new Paragraph(adopet.getPetWeight() + " KG");
		weight.setFixedPosition(130, 638, 100);
		weight.setFont(sysFont);
		weight.setFontSize(13);
		doc.add(weight);

		String location = null;
		switch (adopet.getLocation().toString()) {
		case "TAOYUAN":
			location = "320桃園市中壢區中大路300號";
			break;

		case "TAICHUNG":
			location = "404台中市北區健行路490號";
			break;
		case "KAOHSIUNG":
			location = "812高雄市小港區松和路1號";
			break;
		}
		
		Paragraph loca = new Paragraph(location);
		loca.setFixedPosition(335, 638, 400);
		loca.setFont(sysFont);
		loca.setFontSize(13);
		doc.add(loca);

		Paragraph breed = new Paragraph(adopet.getPetBreed());
		breed.setFixedPosition(334, 668, 400);
		breed.setFont(sysFont);
		breed.setFontSize(13);
		doc.add(breed);

		Paragraph petNo = new Paragraph(adopet.getAdoPetNo().toString());
		petNo.setFixedPosition(335, 695, 400);
		petNo.setFont(sysFont);
		petNo.setFontSize(13);
		doc.add(petNo);

		Paragraph phone = new Paragraph(breeder.getBreederPhone());
		phone.setFixedPosition(160, 325, 100);
		phone.setFont(sysFont);
		phone.setFontSize(13);
		doc.add(phone);

		Image id = new Image(ImageDataFactory.create(param.getIdLeft().getBytes()));
		id.scaleAbsolute(240, 170);
		id.setFixedPosition(50, 110);
		doc.add(id);

		Image id2 = new Image(ImageDataFactory.create(param.getIdRight().getBytes()));
		id2.scaleAbsolute(240, 170);
		id2.setFixedPosition(320, 110);
		doc.add(id2);

		Image sign = new Image(ImageDataFactory.create(param.getSignature().getBytes()));
		sign.scaleAbsolute(120, 70);
		sign.setFixedPosition(110, 25);
		doc.add(sign);

		Paragraph email = new Paragraph(param.getEmail());
		email.setFixedPosition(370, 325, 250);
		email.setFont(sysFont);
		email.setFontSize(13);
		doc.add(email);

		doc.close();

		byte[] bytes = byteArrayOutputStream.toByteArray();

		adopet.setAppForm(bytes);

		adoPetRepository.save(adopet);

	}

	@Override
	public void updateAppForm(PdfParam param) throws IOException, MessagingException {
		AdoPet adopet = adoPetRepository.findByAdoPetNo(param.getAdoPetNo());
		Employee emp = employeeRepository.findByEmpNo(param.getEmpNo()).get();

		InputStream oldPdf = new ByteArrayInputStream(adopet.getAppForm());
		ByteArrayOutputStream pipeforDB = new ByteArrayOutputStream();

		PdfDocument newPdf = new PdfDocument(new PdfReader(oldPdf), new PdfWriter(pipeforDB));
		File stempFile = new File(resourceLoader.getResource(pdfPath).getFile(), "stemp.gif");
		byte[] fileContent = Files.readAllBytes(stempFile.toPath());

		File importFontPath = new File(resourceLoader.getResource(pdfPath).getFile(), "simsun.ttc");

		PdfFont sysFont = PdfFontFactory.createFont(importFontPath + ",1", PdfEncodings.IDENTITY_H, false);
		Document newdoc = new Document(newPdf);

		Image stamp2 = new Image(ImageDataFactory.create(fileContent));
		stamp2.scaleAbsolute(60, 60);
		stamp2.setFixedPosition(490, 55);
		stamp2.setRotationAngle(12);
		newdoc.add(stamp2);

		Paragraph staff = new Paragraph(
				"領養日期: " + LocalDate.now() + "\r\n" + "承辦員工: " + emp.getEmpNo() + "-" + emp.getEmpName());
		staff.setFontSize(15);
		staff.setFont(sysFont);
		staff.setFixedPosition(360, 40, 200);
		newdoc.add(staff);

		newdoc.close();

		byte[] bytes = pipeforDB.toByteArray();
		adopet.setAppForm(bytes);
		adopet.setEmployee(emp);
		adopet.setAdoStatus(AdoStatusEnum.ADOPTED);

		adopet = adoPetRepository.save(adopet);

		Breeder breeder = adopet.getBreeder();

		String messageText = "親愛的 " + breeder.getBreederName() + " 先生/女士您好，" + "\n\n" + "附件為領養申請書，請查收。" + "\n\n"
				+ "祝您有美好的一天" + "\n" + "Petfect Match";

		mailService.sendEmail(breeder.getBreederEmail(), "Petfect Match 領養申請書", messageText, adopet.getAppForm());

	}
}
