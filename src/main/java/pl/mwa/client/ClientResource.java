package pl.mwa.client;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.mwa.representative.Representative;


@RequestMapping("/clients")
@RestController
public class ClientResource {
	
	@Autowired
	ClientServiceImpl cs;

	public ClientResource(ClientServiceImpl cs) {
		this.cs = cs;
	}
	
	
	 @GetMapping("/{id}")
	 ResponseEntity getClient(@PathVariable Long id){
	        Client client = cs.findOne(id);
	        return ResponseEntity.ok(client);
	}
	
	
    @GetMapping
    ResponseEntity getClients(){
        return ResponseEntity.ok(cs.findAll());
    }

    @PostMapping
    ResponseEntity createClient(@Valid @RequestBody Client client){
        cs.save(client);
        return ResponseEntity.ok(client.getId());
    }
    
    
    @DeleteMapping("/{id}")
    ResponseEntity deleteClient(@PathVariable Long id){
    	cs.remove(id);
        return ResponseEntity.accepted().build();
    }
    
    
    @PutMapping
    ResponseEntity updateClient(@Valid @RequestBody Client client){
    	cs.save(client);
        return ResponseEntity.accepted().build();
    }
    
}