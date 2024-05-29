package in.cerpsoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.cerpsoft.entity.RoomSetupEntity;

@Repository
public interface RoomSetupRepository extends JpaRepository<RoomSetupEntity, Long>{

}
