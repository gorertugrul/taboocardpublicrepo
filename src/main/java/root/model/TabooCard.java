package root.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.Objects;

@Document
public class TabooCard {
    @Id
    private String mainWord;
    private String forbiddenWord1;
    private String forbiddenWord2;
    private String forbiddenWord3;
    private String forbiddenWord4;
    private String forbiddenWord5;
    private String provider;
    private String category;
    private String eMail;
    private Date dateCreated;

    public TabooCard(String mainWord, String forbiddenWord1,
                     String forbiddenWord2, String forbiddenWord3,
                     String forbiddenWord4, String forbiddenWord5, String provider,
                     String category, String eMail, Date dateCreated) {
        this.mainWord = mainWord;
        this.forbiddenWord1 = forbiddenWord1;
        this.forbiddenWord2 = forbiddenWord2;
        this.forbiddenWord3 = forbiddenWord3;
        this.forbiddenWord4 = forbiddenWord4;
        this.forbiddenWord5 = forbiddenWord5;
        this.provider = provider;
        this.category = category;
        this.eMail = eMail;
        this.dateCreated = dateCreated;
    }

    public String getMainWord() {
        return mainWord;
    }

    public void setMainWord(String mainWord) {
        this.mainWord = mainWord;
    }

    public String getForbiddenWord1() {
        return forbiddenWord1;
    }

    public void setForbiddenWord1(String forbiddenWord1) {
        this.forbiddenWord1 = forbiddenWord1;
    }

    public String getForbiddenWord2() {
        return forbiddenWord2;
    }

    public void setForbiddenWord2(String forbiddenWord2) {
        this.forbiddenWord2 = forbiddenWord2;
    }

    public String getForbiddenWord3() {
        return forbiddenWord3;
    }

    public void setForbiddenWord3(String forbiddenWord3) {
        this.forbiddenWord3 = forbiddenWord3;
    }

    public String getForbiddenWord4() {
        return forbiddenWord4;
    }

    public void setForbiddenWord4(String forbiddenWord4) {
        this.forbiddenWord4 = forbiddenWord4;
    }

    public String getForbiddenWord5() {
        return forbiddenWord5;
    }

    public void setForbiddenWord5(String forbiddenWord5) {
        this.forbiddenWord5 = forbiddenWord5;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TabooCard tabooCard = (TabooCard) o;
        return mainWord.equals(tabooCard.mainWord);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mainWord);
    }
}
