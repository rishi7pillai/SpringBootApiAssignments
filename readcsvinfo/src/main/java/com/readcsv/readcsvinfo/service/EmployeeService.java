package com.readcsv.readcsvinfo.service;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.readcsv.readcsvinfo.dao.AddressDao;
import com.readcsv.readcsvinfo.dao.DemographyDao;
import com.readcsv.readcsvinfo.dao.EmployeeDao;
import com.readcsv.readcsvinfo.model.AddressInfo;
import com.readcsv.readcsvinfo.model.DemographyInfo;
import com.readcsv.readcsvinfo.model.EmployeeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private AddressDao addressDao;
    @Autowired
    private DemographyDao demographyDao;
    @Autowired
    private EmployeeDao employeeDao;

    String fileLocation = "D:\\AA2\\Hr1m.csv";


    public void uploadCsvFile(){
        if(!fileLocation.isEmpty())
        {
            try (BufferedReader reader = new BufferedReader(new FileReader(fileLocation)))
            {
                System.out.println("Csv is going to upload +++++++++++");
                List<String> allEmployeeDetails=new ArrayList<String>();
                String row;

                while((row= reader.readLine())!=null){
                    allEmployeeDetails.add(row);
                }
                List<EmployeeInfo> empList = new ArrayList<>();
                List<DemographyInfo> demoList = new ArrayList<>();
                List<AddressInfo> addList = new ArrayList<>();

                for(int i = 0; i < 10; i++) {
                    String elements = allEmployeeDetails.get(i);
                    String records[] = elements.split(",");

                    EmployeeInfo employeeInfo = new EmployeeInfo();
                    DemographyInfo demographyInfo = new DemographyInfo();
                    AddressInfo addressInfo = new AddressInfo();

                    employeeInfo.setEmployeeId(records[0]);
                    employeeInfo.setFirstName(records[2]);
                    employeeInfo.setLastName(records[4]);
                    employeeInfo.setGender(records[5]);
                    employeeInfo.setEmail(records[6]);
                    empList.add(employeeInfo);


                    demographyInfo.setAge(records[12]);
                    demographyInfo.setDob(records[10]);
                    demographyInfo.setFatherName(records[7]);
                    demographyInfo.setWeight(records[13]);
                    demographyInfo.setMotherName(records[8]);
                    demoList.add(demographyInfo);


                    addressInfo.setCity(records[31]);
                    addressInfo.setCountry(records[30]);
                    addressInfo.setState(records[32]);
                    addressInfo.setRegion(records[33]);
                    addressInfo.setZip(records[34]);
                    addList.add(addressInfo);



                }


                for(EmployeeInfo emp:empList){
                    employeeDao.save(emp);
                }

                for(DemographyInfo demo:demoList){
                    demographyDao.save(demo);
                }

                for(AddressInfo add:addList){
                    addressDao.save(add);
                }

                System.out.println("csv uploaded +++++++++++++");


            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }


    }




    public static List<List<String>> getEmployee() throws IOException {

        List<List<String>> finalList=new ArrayList<List<String>>();

        List<String> allEmployeeDetails=new ArrayList<String>();
        String fileLoc = "D:\\AA2\\Hr1m.csv";


        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileLoc));
        String row;

        while((row= bufferedReader.readLine())!=null){
            allEmployeeDetails.add(row);
        }

        for(int i = 0; i < 10; i++){
            String elements = allEmployeeDetails.get(i);
            String records[] = elements.split(",");

            EmployeeInfo employeeInfo = new EmployeeInfo();
            DemographyInfo demographyInfo = new DemographyInfo();
            AddressInfo addressInfo = new AddressInfo();

            employeeInfo.setEmployeeId(records[0]);
            employeeInfo.setFirstName(records[2]);
            employeeInfo.setLastName(records[4]);
            employeeInfo.setGender(records[5]);
            employeeInfo.setEmail(records[6]);



            demographyInfo.setAge(records[12]);
            demographyInfo.setDob(records[10]);
            demographyInfo.setFatherName(records[7]);
            demographyInfo.setWeight(records[13]);
            demographyInfo.setMotherName(records[8]);


            addressInfo.setCity(records[31]);
            addressInfo.setCountry(records[30]);
            addressInfo.setState(records[32]);
            addressInfo.setRegion(records[33]);
            addressInfo.setZip(records[34]);

            List<String> allList=new ArrayList<>();


            //str.add(element);
            allList.add(employeeInfo.getEmployeeId());
           allList.add(employeeInfo.getFirstName());
            allList.add(employeeInfo.getLastName());
            allList.add(employeeInfo.getGender());
            allList.add(employeeInfo.getEmail());
            allList.add(demographyInfo.getFatherName());
            allList.add(demographyInfo.getMotherName());
            allList.add(demographyInfo.getAge());
            allList.add(demographyInfo.getDob());
            allList.add(demographyInfo.getWeight());
            allList.add(addressInfo.getCity());
            allList.add(addressInfo.getState());
            allList.add(addressInfo.getRegion());
            allList.add(addressInfo.getCountry());
            allList.add(addressInfo.getZip());

            finalList.add(allList);


        }

        return  finalList;
    }



//    public void uploadCsvFl(){
//        if(!fileLocation.isEmpty())
//        {
//            try (Reader reader = new BufferedReader(new FileReader(fileLocation)))
//            {
//                System.out.println("Csv is going to upload +++++++++++");
//                CsvToBean<EmployeeInfo> csvTobean = new CsvToBeanBuilder(reader)
//                        .withType(EmployeeInfo.class)
//                        .withIgnoreLeadingWhiteSpace(true)
//                        .build();
//                List<EmployeeInfo> empList = csvTobean.parse();
//
//                int i=0;
//                for(EmployeeInfo emp:empList){
//                    i++;
//                    employeeDao.save(emp);
//                    if(i==10){
//                        break;
//                    }
//                }
//
//
//
//
//                System.out.println("csv uploaded +++++++++++++");
//
//
//            }
//            catch(Exception e) {
//                e.printStackTrace();
//            }
//        }
//
//
//    }

}
