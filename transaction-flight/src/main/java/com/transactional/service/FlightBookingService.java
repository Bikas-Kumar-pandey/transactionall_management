package com.transactional.service;

import com.transactional.dto.FlightBookingAcknowledgment;
import com.transactional.dto.FlightBookingRequest;
import com.transactional.entity.PassengerInfo;
import com.transactional.entity.PaymentInfo;
import com.transactional.repo.PassengerRepo;
import com.transactional.repo.PaymentRepo;
import com.transactional.utils.PaymentUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
@Transactional//(readOnly=false,Isolation= Isolation.READ_COMMITTED,propagation= Propagation.REQUIRED)
public class FlightBookingService {
    @Autowired
    private PassengerRepo passengerRepo;

    @Autowired
    private PaymentRepo paymentRepo;

    public FlightBookingAcknowledgment bookingFlightTicket(FlightBookingRequest request){

        PassengerInfo passengerInfo = request.getPassengerInfo();
        passengerInfo = passengerRepo.save(passengerInfo);

        PaymentInfo paymentInfos = request.getPaymentInfo();
        PaymentUtils.validateCreditLimit(paymentInfos.getAccountNo(),passengerInfo.getFare());

        paymentInfos.setPassengerId(passengerInfo.getPid());
        paymentInfos.setAmount(passengerInfo.getFare());

        paymentRepo.save(paymentInfos);



        return new FlightBookingAcknowledgment("SUCCESS",passengerInfo.getFare(), UUID.randomUUID().toString().split("-")[0],passengerInfo);
    }

}
