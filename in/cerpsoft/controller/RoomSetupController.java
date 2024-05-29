package in.cerpsoft.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.cerpsoft.entity.RoomSetupEntity;
import in.cerpsoft.service.HostalService;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/rooms/")
@RequiredArgsConstructor
public class RoomSetupController {
	private static final Logger LOGGER = LoggerFactory.getLogger(RoomSetupController.class);

	private final HostalService hostalService;

	@PostMapping("/save-room-setup")
	public ResponseEntity<RoomSetupEntity> saveRoomSetup(@RequestBody @Valid RoomSetupEntity entity) {
		LOGGER.info("Invoking save Method...");
		return new ResponseEntity<>(hostalService.saveRoomSetup(entity), HttpStatus.CREATED);
	}

	@GetMapping("/fetch-all-datas")
	public ResponseEntity<List<RoomSetupEntity>> fetchRoomSetup() {
		return new ResponseEntity<>(hostalService.fetchAllRooms().toList(), HttpStatus.OK);
	}

	// http://localhost:8080/api/v1/rooms/find-by-id/1
	@GetMapping("/find-by-id/{id}")
	public ResponseEntity<RoomSetupEntity> findByIdRoomSetup(@PathVariable long id) {
		return new ResponseEntity<>(hostalService.findById(id), HttpStatus.OK);
	}

	// http://localhost:8080/api/v1/rooms/update-room-setup?id=1
	@PutMapping("/update-room-setup")
	public ResponseEntity<RoomSetupEntity> updateRoomSetup(@PathParam("id") long id,
			@RequestBody RoomSetupEntity entity) {
		return new ResponseEntity<>(hostalService.updateRoomSet(entity, id), HttpStatus.OK);
	}

	@DeleteMapping("/delete-room-set")
	public ResponseEntity<String> deleteRoomSetup(@PathParam("id") long id) {
		hostalService.deleteRoomSetup(id);
		return new ResponseEntity<>("Successfully Deleted...", HttpStatus.OK);
	}
}
