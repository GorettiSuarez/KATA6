package kata6;

import java.util.ArrayList;

public class MailHistogramBuilder {
    
    public static Histogram<String> buil (ArrayList<String> mailList){
        Histogram<String> histogram = new Histogram<>();
        for (String mail : mailList) {
            Mail domi = new Mail(mail);
            histogram.increment(domi.getDominio());
            //histogram.increment(new Mail (mail).getDominio());
        }
        
        return histogram;
    }
}
