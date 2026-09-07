package email;

public class EmailObjectBuilder implements EmailBuilder {

    private static final String AT_SIGN = "@";
    private static final String NO_ATTACHMENT = "none";

    private String from;
    private String to;
    private String subject;
    private String body;
    private String attachment = NO_ATTACHMENT;

    @Override
    public EmailObjectBuilder setFrom(String from) {
        this.from = from;
        return this;
    }

    @Override
    public EmailObjectBuilder setTo(String to) {
        this.to = to;
        return this;
    }

    @Override
    public EmailObjectBuilder setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    @Override
    public EmailObjectBuilder setBody(String body) {
        this.body = body;
        return this;
    }

    @Override
    public EmailObjectBuilder setAttachment(String attachment) {
        this.attachment = attachment;
        return this;
    }

    public Email getResult() {
        if (from == null || to == null) {
            throw new IllegalStateException("sender and receiver are required");
        }
        if (!from.contains(AT_SIGN) || !to.contains(AT_SIGN)) {
            throw new IllegalStateException("address must contain " + AT_SIGN);
        }
        if (subject == null) {
            throw new IllegalStateException("subject is required");
        }
        return new Email(from, to, subject, body, attachment);
    }
}
