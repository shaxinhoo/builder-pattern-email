package email;

public interface EmailBuilder {

    EmailBuilder setFrom(String from);

    EmailBuilder setTo(String to);

    EmailBuilder setSubject(String subject);

    EmailBuilder setBody(String body);

    EmailBuilder setAttachment(String attachment);
}
