package beans;

public class Prescription {

    private String doctorname;
    private String prescriptionid;
    private String useremail; 
    private String drugname;
    private String usinginfo;

  
    public String getDoctorname() {
        return doctorname;
    }

    
    public void setDoctorname(String doctorname) {
        this.doctorname = doctorname;
    }

 
    public String getPrescriptionid() {
        return prescriptionid;
    }

 
    public void setPrescriptionid(String prescriptionid) {
        this.prescriptionid = prescriptionid;
    }

  
    public String getUseremail() {
        return useremail;
    }

   
    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public String getDrugname() {
        return drugname;
    }

    
    public void setDrugname(String drugname) {
        this.drugname = drugname;
    }

    public String getUsinginfo() {
        return usinginfo;
    }

    
    public void setUsinginfo(String usinginfo) {
        this.usinginfo = usinginfo;
    }

   
}
