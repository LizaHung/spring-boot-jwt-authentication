package com.pet.adoption.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.pet.adoption.common.EmpAccStatusEnum;
import com.pet.adoption.dto.param.EmployeeParam;
import com.pet.adoption.dto.param.ForgotPswParam;
import com.pet.adoption.exception.UserNotFoundException;
import com.pet.adoption.model.Employee;
import com.pet.adoption.repository.ChangePswParam;
import com.pet.adoption.repository.EmployeeRepository;
import com.pet.adoption.specification.EmployeeSpecification;
import com.pet.adoption.util.ModelMapperUtil;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private EmpAuthorityService empAuthorityService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private ModelMapperUtil modelMapperUtil;

	@Autowired
	private JavaMailSender javaMailSender;

	@Override
	public List<Employee> findAllEmployee() {

		return employeeRepository.findAll();
	}

	@Override
	public List<Employee> searchEmployee(Specification<Employee> spec) {
		return employeeRepository.findAll(spec);
	}

	@Override
	public Optional<Employee> findByEmpName(String empName) {
		return employeeRepository.findByEmpName(empName);
	}

	@Override
	public Optional<Employee> findByEmpNo(Long empNo) {
		return employeeRepository.findByEmpNo(empNo);
	}

	@Override
	public Optional<Employee> findByEmpAccount(String empAccount) {
		return employeeRepository.findByEmpAccount(empAccount);
	}

	@Override
	public Employee saveEmployee(EmployeeParam theEmployee) throws IOException {
		theEmployee.setEmpPsw(passwordEncoder.encode(theEmployee.getEmpPsw()));
		theEmployee.setEmpAccStatus(EmpAccStatusEnum.VALID.toString());
		Employee emp = modelMapperUtil.map(theEmployee, Employee.class);
		if (theEmployee.getEmpPhoto() != null)
			emp.setEmpPhoto(theEmployee.getEmpPhoto().getBytes());
		Employee savedEmp = employeeRepository.save(emp);
		empAuthorityService.saveFunByRole(savedEmp.getEmpNo(), savedEmp.getEmpRole());
		return savedEmp;
	}

	@Override
	@Transactional
	public Employee updateEmployee(EmployeeParam theEmployee) throws IOException {
		Employee tempEmp = modelMapperUtil.map(theEmployee, Employee.class);
		tempEmp.setEmpAccStatus(EmpAccStatusEnum.VALID);
		if (theEmployee.getEmpPhoto() != null)
			tempEmp.setEmpPhoto(theEmployee.getEmpPhoto().getBytes());
		if (StringUtils.isNoneBlank(theEmployee.getEmpPsw()))
			tempEmp.setEmpPsw(passwordEncoder.encode(theEmployee.getEmpPsw()));
		empAuthorityService.saveFunByRole(tempEmp.getEmpNo(), tempEmp.getEmpRole());
		return employeeRepository.save(tempEmp);
	}

	@Override
	public Employee updateEmployeeAccStatus(Long empNo) {
		Employee emp = employeeRepository.findByEmpNo(empNo).get();
		emp.setEmpAccStatus(EmpAccStatusEnum.INVALID);
		return employeeRepository.save(emp);
	}

	@Override
	public void validEmp(ForgotPswParam forgotPswParam) throws MessagingException, UnsupportedEncodingException {
		EmployeeParam param = new EmployeeParam();
		param.setEmpEmail(forgotPswParam.getEmail());
		param.setEmpAccount(forgotPswParam.getAccount());
		Specification<Employee> spec = EmployeeSpecification.searchEmp(param);

		List<Employee> result = employeeRepository.findAll(spec);
		if (result.size() > 0) {
			Employee emp = result.get(0);
			MimeMessage mimeMessage = javaMailSender.createMimeMessage();

			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

			String url = String.join("-", "http://localhost:9001/#/change-psw?",
					Base64.getEncoder().encodeToString(emp.getEmpAccount().getBytes()),
					Base64.getEncoder().encodeToString(Long.toString(System.currentTimeMillis()).getBytes()));

			String messageText = "親愛的 " + emp.getEmpName() + " 先生/女士您好，" + "\n\n" + "請於三十分鐘內至" + url + "\n\n"
					+ "變更您的密碼，謝謝" + "\n\n" + "祝您有美好的一天" + "\n" + "Petfect";

			helper.setTo(emp.getEmpEmail());
			helper.setSubject("主旨：忘記密碼");

			helper.setText(messageText);

			javaMailSender.send(mimeMessage);
		} else
			throw new UserNotFoundException("Employee email or account not found");

	}

	@Override
	public Employee ChangePsw(ChangePswParam forgotPswParam) {
		Employee emp = employeeRepository.findByEmpAccount(forgotPswParam.getAccount()).get();
		if (emp == null)
			throw new UserNotFoundException("Employee email or account not found");
		emp.setEmpPsw(passwordEncoder.encode(forgotPswParam.getPassword()));
		return employeeRepository.save(emp);

	}

}
