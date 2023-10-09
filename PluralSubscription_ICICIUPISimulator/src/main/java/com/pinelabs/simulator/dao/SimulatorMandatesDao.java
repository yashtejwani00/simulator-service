package com.pinelabs.simulator.dao;

import com.pinelabs.simulator.entity.SimulatorMandatesTable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SimulatorMandatesDao extends CrudRepository<SimulatorMandatesTable, Long> {
}
