package mr.devfam.moonlight;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import mr.devfam.moonlight.dao.CategoryRepository;
import mr.devfam.moonlight.dao.ProductRepository;
import mr.devfam.moonlight.entities.Category;
import mr.devfam.moonlight.entities.Product;
import net.bytebuddy.utility.RandomString;

@SpringBootApplication
public class ECommerceApplication implements CommandLineRunner{
	
	@Autowired
	private ProductRepository productRepo;
	@Autowired
	private CategoryRepository categoryRepo;
	
	@Autowired
	RepositoryRestConfiguration restConfig;
	
	public static void main(String[] args) {
		SpringApplication.run(ECommerceApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		// INITILIZING DB WITH MOCK DATA
		Random random = new Random();
		
		categoryRepo.save(new Category(null, "Computers", null, null, null));
		categoryRepo.save(new Category(null, "Printers", null, null, null));
		categoryRepo.save(new Category(null, "Smart Phones", null, null, null));
		
		categoryRepo.findAll().forEach(c->{
			for (int i = 0; i < 10; i++) {
				Product p = new Product();
				p.setName(RandomString.make(18));
				p.setCategory(c);
				p.setCurrentPrice(100 + random.nextInt(10000));
				p.setAvailable(random.nextBoolean());
				p.setPromotion(random.nextBoolean());
				p.setSelected(random.nextBoolean());
				p.setPhotoName("unknown.png");
				
				productRepo.save(p);
			}
		});
		
		
		//CONFIGURE SPRING DATA REST
		restConfig.exposeIdsFor(Product.class, Category.class);
	}

}
