package mr.devfam.moonlight.web;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import mr.devfam.moonlight.dao.ProductRepository;
import mr.devfam.moonlight.entities.Product;

@RestController
public class CatalogueRestController {
	private ProductRepository productRepo;
	
	public CatalogueRestController(ProductRepository productRepository){
		this.productRepo = productRepository;
	}
	
	@GetMapping(path = "/photoProduct/{id}", produces = MediaType.IMAGE_PNG_VALUE)
	public byte[] getPhoto(@PathVariable Long id) throws Exception{
		// RECUPERER LA PHOTO DU PRODUIT ET ON L'ENVOIE VERS LE FONTEND
		Product product = productRepo.findById(id).get();
		
		return Files.readAllBytes(Paths.get(System.getProperty(
				"user.home")+
				"/media/EComerceWithYoussfi/products/"+
				product.getPhotoName()));
		
		
	}
}
