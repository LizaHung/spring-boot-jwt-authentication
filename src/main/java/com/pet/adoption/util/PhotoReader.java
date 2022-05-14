package com.pet.adoption.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
@Component
public class PhotoReader {
	public void readPhoto(HttpServletResponse res, byte[] photo) throws IOException {
		res.setContentType("image/gif");
		ServletOutputStream out = res.getOutputStream();
		byte[] buf = new byte[4 * 1024];
		ByteArrayInputStream bin = new ByteArrayInputStream(photo);

		int len;
		while ((len = bin.read(buf)) != -1) {
			out.write(buf, 0, len);
		}
		bin.close();
		out.close();
	}

}
