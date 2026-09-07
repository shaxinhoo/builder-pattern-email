package email;

public class EmailDirector {

    private static final String SUPPORT_ADDRESS = "support@shop.kz";
    private static final String REPORTS_ADDRESS = "reports@shop.kz";
    private static final String NO_FILE = "none";
    private static final String REPORT_FILE = "report.pdf";

    public void makeWelcomeEmail(EmailBuilder builder, String customer) {
        builder.setFrom(SUPPORT_ADDRESS)
                .setTo(customer)
                .setSubject("welcome to our shop")
                .setBody("hello, thank you for creating an account")
                .setAttachment(NO_FILE);
    }

    public void makeReportEmail(EmailBuilder builder, String manager) {
        builder.setFrom(REPORTS_ADDRESS)
                .setTo(manager)
                .setSubject("monthly report")
                .setBody("please find the monthly report in the attachment")
                .setAttachment(REPORT_FILE);
    }
}
