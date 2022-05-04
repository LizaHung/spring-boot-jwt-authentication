/**
 * 
 */
package com.pet.adoption.dto.param;

import java.util.List;

import lombok.Data;

/**
 * @author <a href="mailto:lizahung1008@gmail.com"> Liza Hung</a>
 *
 */
@Data
public class EmpAuthorityParam {
	private Long empNo;
	private List<Integer> funNo;
}
