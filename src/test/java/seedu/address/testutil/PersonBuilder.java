package seedu.address.testutil;

import java.util.HashSet;
import java.util.Set;

import seedu.address.model.tag.Tag;
import seedu.address.model.tutee.*;
import seedu.address.model.util.SampleDataUtil;

/**
 * A utility class EndTime help with building Tutee objects.
 */
public class PersonBuilder {

    public static final String DEFAULT_NAME = "Amy Bee";
    public static final String DEFAULT_PHONE = "85355255";
    public static final String DEFAULT_EMAIL = "amy@gmail.com";
    public static final String DEFAULT_ADDRESS = "123, Jurong West Ave 6, #08-111";
    public static final String DEFAULT_REMARK = "";
    public static final String DEFAULT_SUBJECT = "Math";
    public static final String DEFAULT_SCHEDULE = "friday";
    public static final String DEFAULT_STARTTIME = "10:30";
    public static final String DEFAULT_ENDTIME = "12:30";

    private Name name;
    private Phone phone;
    private Email email;
    private Address address;
    private Remark remark;
    private Subject subject;
    private Schedule schedule;
    private StartTime startTime;
    private EndTime endTime;
    private Set<Tag> tags;

    /**
     * Creates a {@code PersonBuilder} with the default details.
     */
    public PersonBuilder() {
        name = new Name(DEFAULT_NAME);
        phone = new Phone(DEFAULT_PHONE);
        email = new Email(DEFAULT_EMAIL);
        address = new Address(DEFAULT_ADDRESS);
        remark = new Remark(DEFAULT_REMARK);
        subject = new Subject(DEFAULT_SUBJECT);
        schedule = new Schedule(DEFAULT_SCHEDULE);
        startTime = new StartTime(DEFAULT_STARTTIME);
        endTime = new EndTime(DEFAULT_ENDTIME);
        tags = new HashSet<>();
    }

    /**
     * Initializes the PersonBuilder with the data of {@code tuteeToCopy}.
     */
    public PersonBuilder(Tutee tuteeToCopy) {
        name = tuteeToCopy.getName();
        phone = tuteeToCopy.getPhone();
        email = tuteeToCopy.getEmail();
        address = tuteeToCopy.getAddress();
        remark = tuteeToCopy.getRemark();
        subject = tuteeToCopy.getSubject();
        schedule = tuteeToCopy.getSchedule();
        startTime = tuteeToCopy.getStartTime();
        endTime = tuteeToCopy.getEndTime();
        tags = new HashSet<>(tuteeToCopy.getTags());
    }

    /**
     * Sets the {@code Name} of the {@code Tutee} that we are building.
     */
    public PersonBuilder withName(String name) {
        this.name = new Name(name);
        return this;
    }

    /**
     * Parses the {@code tags} into a {@code Set<Tag>} and set it EndTime the {@code Tutee} that we are building.
     */
    public PersonBuilder withTags(String ... tags) {
        this.tags = SampleDataUtil.getTagSet(tags);
        return this;
    }

    /**
     * Sets the {@code Address} of the {@code Tutee} that we are building.
     */
    public PersonBuilder withAddress(String address) {
        this.address = new Address(address);
        return this;
    }

    /**
     * Sets the {@code Phone} of the {@code Tutee} that we are building.
     */
    public PersonBuilder withPhone(String phone) {
        this.phone = new Phone(phone);
        return this;
    }

    /**
     * Sets the {@code Email} of the {@code Tutee} that we are building.
     */
    public PersonBuilder withEmail(String email) {
        this.email = new Email(email);
        return this;
    }

    /**
     * Sets the {@code Remark} of the {@code Tutee} that we are building.
     */
    public PersonBuilder withRemark(String remark) {
        this.remark = new Remark(remark);
        return this;
    }

    /**
     * Sets the {@code Subject} of the {@code Tutee} that we are building.
     */
    public PersonBuilder withSubject(String subject) {
        this.subject = new Subject(subject);
        return this;
    }

    /**
     * Sets the {@code Schedule} of the {@code Tutee} that we are building.
     */
    public PersonBuilder withSchedule(String schedule) {
        this.schedule = new Schedule(schedule);
        return this;
    }

    /**
     * Sets the {@code startTime} of the {@code Tutee} that we are building.
     */
    public PersonBuilder withStartTime(String startTime) {
        this.startTime = new StartTime(startTime);
        return this;
    }

    /**
     * Sets the {@code endTime} of the {@code Tutee} that we are building.
     */
    public PersonBuilder withEndTime(String endTime) {
        this.endTime = new EndTime(endTime);
        return this;
    }


    public Tutee build() {
        return new Tutee(name, phone, email, address, remark, subject, schedule, startTime, endTime, tags);
    }

}
