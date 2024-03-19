package com.bancolombia.feigns;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.bancolombia.entities.Articulo;

/*Create the Feign client that
 * connecting to micro-articulo*/

//@FeignClient(name="micro-articulo", url="http://localhost:8081")  //Sin Eureka
@FeignClient(name="micro-articulo")  // Con eureka para que eureka balancee
public interface IFeignClientMicroArticulo {
	@GetMapping("/articulo/{id}")
	Articulo findById(@PathVariable("id") int id);
}
