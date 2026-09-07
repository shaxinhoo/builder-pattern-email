package email;

public class Main {

    public static void main(String[] args) {
        EmailDirector director = new EmailDirector();
        String customer = "aigerim@mail.kz";
        String manager = "manager@shop.kz";

        EmailObjectBuilder objectBuilder = new EmailObjectBuilder();
        director.makeWelcomeEmail(objectBuilder, customer);
        Email welcome = objectBuilder.getResult();
        System.out.println(welcome);

        EmailPreviewBuilder previewBuilder = new EmailPreviewBuilder();
        director.makeWelcomeEmail(previewBuilder, customer);
        System.out.println();
        System.out.println(previewBuilder.getResult());

        EmailPreviewBuilder reportPreview = new EmailPreviewBuilder();
        director.makeReportEmail(reportPreview, manager);
        System.out.println(reportPreview.getResult());

        Email custom = new EmailObjectBuilder()
                .setFrom("student@astanait.edu.kz")
                .setTo("teacher@astanait.edu.kz")
                .setSubject("Assignment 1")
                .setBody("My Builder pattern assignment is ready")
                .getResult();
        System.out.println(custom);

        try {
            new EmailObjectBuilder()
                    .setFrom("student")
                    .setTo("teacher@astanait.edu.kz")
                    .setSubject("Broken address")
                    .getResult();
        } catch (IllegalStateException e) {
            System.out.println();
            System.out.println("Validation works: " + e.getMessage());
        }
    }
}
