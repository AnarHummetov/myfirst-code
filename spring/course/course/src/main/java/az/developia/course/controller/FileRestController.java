package az.developia.course.controller;



import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.UrlResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import az.developia.course.model.FileModel;
import az.developia.course.repository.FileRepository;
import lombok.Data;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path = "/files")
@CrossOrigin(origins = "*")
public class FileRestController {
	
	@Autowired
	private FileRepository fileRepository;
	
	@Autowired
	private ResourceLoader resourceLoader;

	@Data
	class ResponseBean{
		private String path;
		
	}
	
	@GetMapping(path = "/list")
	public List<FileModel> findAll() {
		return fileRepository.findAll();
	}
	
	
	@PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseBean upload(@RequestParam(name = "fayl") MultipartFile fayl) throws Exception {
		String os = System.getProperty("os.name");
		System.out.println(os);
	
		InputStream stream = fayl.getInputStream();
		String fileName = fayl.getOriginalFilename();

		UUID uuid = UUID.randomUUID();
		String randomName = uuid.toString(); 

		String fileNameWithoutExtention = fileName.substring(0, fileName.lastIndexOf('.'));
		String fileExtension = fileName.substring(fileName.lastIndexOf('.'));

		
		String fileFinalName = fileName.replace(fileNameWithoutExtention, randomName);

		Files.copy(stream, Paths.get("C:/all/java8/" + fileFinalName), StandardCopyOption.REPLACE_EXISTING);
		ResponseBean bean = new ResponseBean();

		FileModel fileModel = new FileModel();
		fileModel.setFileName(fileName);

		fileModel.setFileUUIDName(fileFinalName);
		fileModel.setFileSize(fayl.getSize());

		fileModel.setType(fileExtension);
		fileRepository.save(fileModel);

		bean.setPath(fileFinalName);
		return bean;
	}
	
	@GetMapping(path = "/video/{title}", produces = "video/mp4")
	public Mono<Resource> getVideo(@PathVariable String title, @RequestHeader String range) {
		System.out.println("range : " + range);

		return getVideo(title);

	}
	
	public Mono<Resource> getVideo(String title) {

		return Mono.fromSupplier(() -> resourceLoader.getResource("file:C:\\all\\java8\\" + title));
	}
	
	@GetMapping("/download/{filename:.+}")
	@ResponseBody
	public ResponseEntity<Resource> serveFile(@PathVariable String filename) {

		Resource file = loadAsResource(filename);
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
				.body(file);
	}
	
	public Resource loadAsResource(String filename) {
		try {
			Path file = load(filename);
			Resource resource = new UrlResource(file.toUri());
			if (resource.exists() || resource.isReadable()) {
				return resource;
			} else {

			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Path load(String filename) {
		return rootLocation.resolve(filename);
	}

	private final Path rootLocation = Paths.get("C:/all/java8");
}
