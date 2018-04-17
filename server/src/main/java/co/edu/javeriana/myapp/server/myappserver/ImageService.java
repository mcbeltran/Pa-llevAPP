package co.edu.javeriana.myapp.server.myappserver;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import co.edu.javeriana.myapp.server.myappserver.model.ImageRepository;
import co.edu.javeriana.myapp.server.myappserver.model.RegisteredUser;

@Service
@RestController
@RequestMapping("/services")
@CrossOrigin(origins = "http://localhost:4200")
public class ImageService {
	
	public class Img {
		public byte[] image;

		public byte[] getImage() {
			return image;
		}

		public void setImage(byte[] image) {
			this.image = image;
		}

		public Img(byte[] image) {
			super();
			this.image = image;
		}
		
		
	}
	
	List<byte[]> images = new ArrayList<byte[]>();
	Map<String, Img> stored_images = new HashMap<String, Img>();
	
	@RequestMapping(value = "/upload/{file_name}")
	public void uploadImage( @RequestBody byte[] image, @PathVariable("file_name") String file_name ) {
		stored_images.put(file_name, new Img ( image ) );
	}
	
	@RequestMapping(value = "/load/{file_name}", method = RequestMethod.GET, produces = {MediaType.IMAGE_PNG_VALUE, MediaType.IMAGE_JPEG_VALUE }) 
	public byte[] getImage( @PathVariable("file_name") String file_name ) {

		if( stored_images.containsKey( file_name ) )
			return stored_images.get( file_name ).getImage();
		else
			return null;
		
	}

}
