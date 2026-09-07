package email;

public class EmailPreviewBuilder implements EmailBuilder {

    private static final String HEADER = "=== Email Preview ===\n";
    private static final String LINE_END = "\n";

    private final StringBuilder text = new StringBuilder(HEADER);

    @Override
    public EmailPreviewBuilder setFrom(String from) {
        text.append("From:       ").append(from).append(LINE_END);
        return this;
    }

    @Override
    public EmailPreviewBuilder setTo(String to) {
        text.append("To:         ").append(to).append(LINE_END);
        return this;
    }

    @Override
    public EmailPreviewBuilder setSubject(String subject) {
        text.append("Subject:    ").append(subject).append(LINE_END);
        return this;
    }

    @Override
    public EmailPreviewBuilder setBody(String body) {
        text.append("Body:       ").append(body).append(LINE_END);
        return this;
    }

    @Override
    public EmailPreviewBuilder setAttachment(String attachment) {
        text.append("Attachment: ").append(attachment).append(LINE_END);
        return this;
    }

    public String getResult() {
        if (text.indexOf("Subject:") < 0) {
            throw new IllegalStateException("Subject is required");
        }
        return text.toString();
    }
}
