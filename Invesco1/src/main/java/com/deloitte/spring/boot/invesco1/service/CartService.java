package com.deloitte.spring.boot.invesco1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.deloitte.spring.boot.invesco1.model.Cart;
import com.deloitte.spring.boot.invesco1.model.Product;
import com.deloitte.spring.boot.invesco1.repository.CartRepository;
import com.deloitte.spring.boot.invesco1.repository.ProductRepository;

@Service
public class CartService {
	
	@Autowired
	CartRepository cartRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	
	public List<Cart> viewElements() {
		return cartRepository.findAll();
	}

/*	public String addToCart(Product product) {
		Cart cartu = new Cart();
		//cartu.setCart_no(product.getProduct_id());
		cartu.setProduct_name(product.getProduct_name());
		cartu.setPrice(product.getPrice());
		System.out.print(cartu.getCart_no()+" "+cartu.getPrice()+" "+cartu.getProduct_name());
		
		cartRepository.save(cartu);
		
		return "success";
	}
*/
	

	public Cart deleteCartItems() {
		// TODO Auto-generated method stub
		cartRepository.deleteAll();
		return null;
	}

	public Cart deleteItemByID(int cart_id) {
		// TODO Auto-generated method stub
		Cart car = cartRepository.getById(cart_id);
		if (null != car)
			cartRepository.deleteById(cart_id);
		
		return car;
	}

	public String addToCarts(int product_id) {
		// TODO Auto-generated method stub
		Product pro = productRepository.getById(product_id);
		List<Cart> all = cartRepository.findAll();
		int z=0;
		Cart lastone=null;
		
		for(Cart c:all)
		{
			if(c.getProduct_name().equals(pro.getProduct_name()))
			{
				z=1;
				lastone=c;
			}
		}
		
		
		if(z==1)
		{
			int k=lastone.getQuantity();
			lastone.setQuantity(k+1);
			int bill=lastone.getPrice();
			lastone.setPrice(bill*2);
			cartRepository.save(lastone);
		}
		else
		{
			Cart cartu = new Cart();
			//cartu.setCart_no(product.getProduct_id());
			cartu.setProduct_name(pro.getProduct_name());
			cartu.setPrice(pro.getPrice());
			cartu.setQuantity(1);
			System.out.print(cartu.getCart_no()+" "+cartu.getPrice()+" "+cartu.getProduct_name());	
			cartRepository.save(cartu);
		}
		
		
		return "success";
		
		
	}

	public int getBillOfCartItems() {
		// TODO Auto-generated method stub
		List<Cart> car = cartRepository.findAll();
		int k=0;
		for(Cart c:car)
			k=k+c.getPrice();
			
		return k;
	}

	
	//public static int pricing

}
