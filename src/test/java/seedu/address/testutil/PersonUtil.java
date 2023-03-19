package seedu.address.testutil;

import static seedu.address.logic.parser.CliSyntax.PREFIX_ADDRESS;
import static seedu.address.logic.parser.CliSyntax.PREFIX_EMAIL;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PHONE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_SCHEDULE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_SUBJECT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_STARTTIME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ENDTIME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;

import java.util.Set;

import seedu.address.logic.commands.AddCommand;
import seedu.address.logic.commands.EditCommand.EditPersonDescriptor;
import seedu.address.model.tag.Tag;
import seedu.address.model.tutee.Tutee;

/**
 * A utility class for Tutee.
 */
public class PersonUtil {

    /**
     * Returns an add command string for adding the {@code tutee}.
     */
    public static String getAddCommand(Tutee tutee) {
        return AddCommand.COMMAND_WORD + " " + getPersonDetails(tutee);
    }

    /**
     * Returns the part of command string for the given {@code tutee}'s details.
     */
    public static String getPersonDetails(Tutee tutee) {
        StringBuilder sb = new StringBuilder();
        sb.append(PREFIX_NAME + tutee.getName().fullName + " ");
        sb.append(PREFIX_PHONE + tutee.getPhone().value + " ");
        sb.append(PREFIX_EMAIL + tutee.getEmail().value + " ");
        sb.append(PREFIX_ADDRESS + tutee.getAddress().value + " ");
        sb.append(PREFIX_SUBJECT + tutee.getSubject().subject + " ");
        sb.append(PREFIX_SCHEDULE + tutee.getSchedule().schedule + " ");
        sb.append(PREFIX_STARTTIME + tutee.getStartTime().startTime + " ");
        sb.append(PREFIX_ENDTIME + tutee.getEndTime().endTime + " ");
        tutee.getTags().stream().forEach(
            s -> sb.append(PREFIX_TAG + s.tagName + " ")
        );
        return sb.toString();
    }

    /**
     * Returns the part of command string for the given {@code EditPersonDescriptor}'s details.
     */
    public static String getEditPersonDescriptorDetails(EditPersonDescriptor descriptor) {
        StringBuilder sb = new StringBuilder();
        descriptor.getName().ifPresent(name -> sb.append(PREFIX_NAME).append(name.fullName).append(" "));
        descriptor.getPhone().ifPresent(phone -> sb.append(PREFIX_PHONE).append(phone.value).append(" "));
        descriptor.getEmail().ifPresent(email -> sb.append(PREFIX_EMAIL).append(email.value).append(" "));
        descriptor.getAddress().ifPresent(address -> sb.append(PREFIX_ADDRESS).append(address.value).append(" "));
        descriptor.getSubject().ifPresent(subject -> sb.append(PREFIX_SUBJECT).append(subject.subject).append(" "));
        descriptor.getSchedule().ifPresent(schedule -> sb.append(PREFIX_SCHEDULE).append(schedule.schedule).append(" "));
        descriptor.getStartTime().ifPresent(startTime -> sb.append(PREFIX_STARTTIME).append(startTime.startTime).append(" "));
        descriptor.getEndTime().ifPresent(endTime -> sb.append(PREFIX_ENDTIME).append(endTime.endTime).append(" "));
        if (descriptor.getTags().isPresent()) {
            Set<Tag> tags = descriptor.getTags().get();
            if (tags.isEmpty()) {
                sb.append(PREFIX_TAG);
            } else {
                tags.forEach(s -> sb.append(PREFIX_TAG).append(s.tagName).append(" "));
            }
        }
        return sb.toString();
    }
}
