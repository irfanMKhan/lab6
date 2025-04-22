package com.secured.finallab.service.implementation;


import com.secured.finallab.model.dao.Appointment;
import com.secured.finallab.repository.AppointmentRepository;
import com.secured.finallab.service.AppointmentService;
import org.springframework.stereotype.Service;

@Service
public class AppointmentServiceImplementation implements AppointmentService {

    private final AppointmentRepository appointmentRepository;

    public AppointmentServiceImplementation(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public Appointment save(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

}
