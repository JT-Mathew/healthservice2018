package c.hayeon.seprroject.model;

public class Doctor {
    String docId;
    String docName;

    public String getDocId() {
        return docId;
    }

    public void setDocId(String docId) {
        this.docId = docId;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public Doctor()
    {

    }

    public Doctor(String docId, String docName)
    {
        this.docId = docId;
        this.docName = docName;
    }

}
