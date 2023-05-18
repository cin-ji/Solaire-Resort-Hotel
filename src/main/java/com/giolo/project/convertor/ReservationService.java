package com.giolo.project.convertor;

import com.giolo.project.entity.ReservationEntity;

import java.util.List;

public interface ReservationService {
    public ReservationEntity findLast();
    public List<ReservationEntity> findAll();
}
