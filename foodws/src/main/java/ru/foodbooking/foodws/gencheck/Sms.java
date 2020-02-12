package ru.foodbooking.foodws.gencheck;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.foodbooking.foodws.dao.CodesRepository;
import ru.foodbooking.foodws.dao.model.Codes;
import ru.foodbooking.foodws.gates.SmsGate;

import java.io.IOException;
import java.util.Random;

@Component
public class Sms implements GenerateAndCheck{

    @Autowired
    private CodesRepository codesRepository;

    @Autowired
    private SmsGate smsGate;

    @Override
    public int generateCode(String phone){
        String code = createCode();
        int smsSend = smsGate.sendSms(phone, code);
        if (smsSend == 0) {
            codesRepository.save(new Codes(phone, code, 0));
            return 0;
        }
        return 1;
    }

    @Override
    public int checkCode(String phone, String code) {
        int retCode = 1;
        Codes db = codesRepository.findByClientPhone(phone);
        if (db != null){
            String dbCode = db.getCode();
            if (dbCode.equals(code)){
                retCode = 0;
                codesRepository.delete(db);
            } else {
                Integer dbCount = db.getCounts();
                if (dbCount > 2){
                    codesRepository.delete(db);
                    retCode = 2;
                } else {
                    db.setCounts(dbCount+1);
                    codesRepository.save(db);
                }
            }
        }
        return retCode;
    }

    //TODO переделать генерацию случайного 4х значного числа
    private String createCode(){
        Random rand = new Random();
        String s1 = rand.nextInt(10)+"";
        String s2 = rand.nextInt(10)+"";
        String s3 = rand.nextInt(10)+"";
        String s4 = rand.nextInt(10)+"";
        return s1.substring(0,1)+s2.substring(0,1)+s3.substring(0,1)+s4.substring(0,1);
    }
}
