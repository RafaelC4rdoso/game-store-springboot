package br.com.supera.game.store.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.supera.game.store.entities.Client;
import br.com.supera.game.store.entities.Order;
import br.com.supera.game.store.entities.OrderItem;
import br.com.supera.game.store.entities.Product;
import br.com.supera.game.store.repositories.ClientRepository;
import br.com.supera.game.store.repositories.OrderItemRepository;
import br.com.supera.game.store.repositories.OrderRepository;
import br.com.supera.game.store.repositories.ProductRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	public ProductRepository productRepository;

	@Autowired
	public ClientRepository clientRepository;

	@Autowired
	public OrderRepository orderRepository;
	
	@Autowired
	public OrderItemRepository orderItemRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Product p1 = new Product(null, "Super Mario Odyssey", 197.88, (short)100, "super-mario-odyssey.png");
		Product p2 = new Product(null, "Call Of Duty Infinite Warfare", 49.99, (short)80, "call-of-duty-infinite-warfare.png");
		Product p3 = new Product(null, "The Witcher III Wild Hunt", 119.5, (short)250, "the-witcher-iii-wild-hunt.png");
		Product p4 = new Product(null, "Call Of Duty WWII", 249.99, (short)205, "call-of-duty-wwii.png");
		Product p5 = new Product(null, "Mortal Kombat XL", 69.99, (short)150, "mortal-kombat-xl.png");
		Product p6 = new Product(null, "Shards of Darkness", 71.94, (short)400, "shards-of-darkness.png");
		Product p7 = new Product(null, "Terra Média: Sombras de Mordor", 79.99, (short)50, "terra-media-sombras-de-mordor.png");
		Product p8 = new Product(null, "FIFA 18", 195.39, (short)325, "fifa-18.png");
		Product p9 = new Product(null, "Horizon Zero Dawn", 115.8, (short)290, "horizon-zero-dawn.png");
		productRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		Client c1 = new Client(null, "Joao", "123", "teste", "1234", null);
		Client c2 = new Client(null, "Mario", "1", "xxx", "1", null);
		clientRepository.saveAll(Arrays.asList(c1, c2));
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), c1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), c2);
		orderRepository.saveAll(Arrays.asList(o1, o2));
		
		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
		OrderItem oi2 = new OrderItem(o2, p2, 1, p2.getPrice());
		OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice()); 
		orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3));
	}
}
