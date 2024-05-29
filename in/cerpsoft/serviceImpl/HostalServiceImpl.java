package in.cerpsoft.serviceImpl;

import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import in.cerpsoft.entity.RoomSetupEntity;
import in.cerpsoft.repository.RoomSetupRepository;
import in.cerpsoft.service.HostalService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HostalServiceImpl implements HostalService {

	private final RoomSetupRepository repository;

	@Override
	public RoomSetupEntity saveRoomSetup(RoomSetupEntity entity) {
		return repository.save(entity);
	}

	@Override
	public Stream<RoomSetupEntity> fetchAllRooms() {
		return repository.findAll().parallelStream().distinct();
	}

	@Override
	public RoomSetupEntity findById(long id) {
		return repository.findById(id).orElseThrow(() -> new RuntimeException("Invalid Key : " + id));
	}

	@Override
	public RoomSetupEntity updateRoomSet(RoomSetupEntity entity, long id) {

		var existingInstance = repository.findById(id).orElseThrow(() -> new RuntimeException("Invalid Key : " + id));

		existingInstance.setLocationId(entity.getLocationId());
		existingInstance.setRoomType(entity.getRoomType());
		existingInstance.setRoomNo(entity.getRoomNo());
		existingInstance.setRoomFloor(entity.getRoomFloor());

		repository.save(existingInstance);

		return existingInstance;
	}

	@Override
	public void deleteRoomSetup(long id) {

		repository.findById(id).orElseThrow(() -> new RuntimeException("Invalid Key : " + id));

		repository.deleteById(id);
	}

}
