package com.amplifyframework.datastore.generated.model;

import com.amplifyframework.core.model.temporal.Temporal;

import java.util.List;
import java.util.UUID;
import java.util.Objects;

import androidx.core.util.ObjectsCompat;

import com.amplifyframework.core.model.AuthStrategy;
import com.amplifyframework.core.model.Model;
import com.amplifyframework.core.model.ModelOperation;
import com.amplifyframework.core.model.annotations.AuthRule;
import com.amplifyframework.core.model.annotations.Index;
import com.amplifyframework.core.model.annotations.ModelConfig;
import com.amplifyframework.core.model.annotations.ModelField;
import com.amplifyframework.core.model.query.predicate.QueryField;

import static com.amplifyframework.core.model.query.predicate.QueryField.field;

/** This is an auto generated class representing the Taskmaster type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "Taskmasters", authRules = {
        @AuthRule(allow = AuthStrategy.PUBLIC, operations = { ModelOperation.CREATE, ModelOperation.UPDATE, ModelOperation.DELETE, ModelOperation.READ })
})
@Index(name = "byTeam", fields = {"teamID","title"})
public final class Taskmaster implements Model {
    public static final QueryField ID = field("Taskmaster", "id");
    public static final QueryField TITLE = field("Taskmaster", "title");
    public static final QueryField BODY = field("Taskmaster", "body");
    public static final QueryField STATUS = field("Taskmaster", "status");
    public static final QueryField S3_IMAGE_KEY = field("Taskmaster", "s3ImageKey");
    public static final QueryField TEAM_ID = field("Taskmaster", "teamID");
    private final @ModelField(targetType="ID", isRequired = true) String id;
    private final @ModelField(targetType="String", isRequired = true) String title;
    private final @ModelField(targetType="String") String body;
    private final @ModelField(targetType="Status", isRequired = true) Status status;
    private final @ModelField(targetType="String") String s3ImageKey;
    private final @ModelField(targetType="ID", isRequired = true) String teamID;
    private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime createdAt;
    private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime updatedAt;
    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public Status getStatus() {
        return status;
    }

    public String getS3ImageKey() {
        return s3ImageKey;
    }

    public String getTeamId() {
        return teamID;
    }

    public Temporal.DateTime getCreatedAt() {
        return createdAt;
    }

    public Temporal.DateTime getUpdatedAt() {
        return updatedAt;
    }

    private TaskMaster(String id, String title, String body, Status status, String s3ImageKey, String teamID) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.status = status;
        this.s3ImageKey = s3ImageKey;
        this.teamID = teamID;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if(obj == null || getClass() != obj.getClass()) {
            return false;
        } else {
            TaskMaster taskMaster = (TaskMaster) obj;
            return ObjectsCompat.equals(getId(), taskMaster.getId()) &&
                    ObjectsCompat.equals(getTitle(), taskMaster.getTitle()) &&
                    ObjectsCompat.equals(getBody(), taskMaster.getBody()) &&
                    ObjectsCompat.equals(getStatus(), taskMaster.getStatus()) &&
                    ObjectsCompat.equals(getS3ImageKey(), taskMaster.getS3ImageKey()) &&
                    ObjectsCompat.equals(getTeamId(), taskMaster.getTeamId()) &&
                    ObjectsCompat.equals(getCreatedAt(), taskMaster.getCreatedAt()) &&
                    ObjectsCompat.equals(getUpdatedAt(), taskMaster.getUpdatedAt());
        }
    }

    @Override
    public int hashCode() {
        return new StringBuilder()
                .append(getId())
                .append(getTitle())
                .append(getBody())
                .append(getStatus())
                .append(getS3ImageKey())
                .append(getTeamId())
                .append(getCreatedAt())
                .append(getUpdatedAt())
                .toString()
                .hashCode();
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("TaskMaster {")
                .append("id=" + String.valueOf(getId()) + ", ")
                .append("title=" + String.valueOf(getTitle()) + ", ")
                .append("body=" + String.valueOf(getBody()) + ", ")
                .append("status=" + String.valueOf(getStatus()) + ", ")
                .append("s3ImageKey=" + String.valueOf(getS3ImageKey()) + ", ")
                .append("teamID=" + String.valueOf(getTeamId()) + ", ")
                .append("createdAt=" + String.valueOf(getCreatedAt()) + ", ")
                .append("updatedAt=" + String.valueOf(getUpdatedAt()))
                .append("}")
                .toString();
    }

    public static TitleStep builder() {
        return new Builder();
    }

    /**
     * WARNING: This method should not be used to build an instance of this object for a CREATE mutation.
     * This is a convenience method to return an instance of the object with only its ID populated
     * to be used in the context of a parameter in a delete mutation or referencing a foreign key
     * in a relationship.
     * @param id the id of the existing item this instance will represent
     * @return an instance of this model with only ID populated
     */
    public static Taskmaster justId(String id) {
        return new Taskmaster(
                id,
                null,
                null,
                null,
                null,
                null
        );
    }

    public CopyOfBuilder copyOfBuilder() {
        return new CopyOfBuilder(id,
                title,
                body,
                status,
                s3ImageKey,
                teamID);
    }
    public interface TitleStep {
        StatusStep title(String title);
    }


    public interface StatusStep {
        TeamIdStep status(Status status);
    }


    public interface TeamIdStep {
        BuildStep teamId(String teamId);
    }


    public interface BuildStep {
        Taskmaster build();
        BuildStep id(String id);
        BuildStep body(String body);
        BuildStep s3ImageKey(String s3ImageKey);
    }


    public static class Builder implements TitleStep, StatusStep, TeamIdStep, BuildStep {
        private String id;
        private String title;
        private Status status;
        private String teamID;
        private String body;
        private String s3ImageKey;
        @Override
        public Taskmaster build() {
            String id = this.id != null ? this.id : UUID.randomUUID().toString();

            return new Taskmaster(
                    id,
                    title,
                    body,
                    status,
                    s3ImageKey,
                    teamID);
        }

        @Override
        public StatusStep title(String title) {
            Objects.requireNonNull(title);
            this.title = title;
            return this;
        }

        @Override
        public TeamIdStep status(Status status) {
            Objects.requireNonNull(status);
            this.status = status;
            return this;
        }

        @Override
        public BuildStep teamId(String teamId) {
            Objects.requireNonNull(teamId);
            this.teamID = teamId;
            return this;
        }

        @Override
        public BuildStep body(String body) {
            this.body = body;
            return this;
        }

        @Override
        public BuildStep s3ImageKey(String s3ImageKey) {
            this.s3ImageKey = s3ImageKey;
            return this;
        }

        /**
         * @param id id
         * @return Current Builder instance, for fluent method chaining
         */
        public BuildStep id(String id) {
            this.id = id;
            return this;
        }
    }


    public final class CopyOfBuilder extends Builder {
        private CopyOfBuilder(String id, String title, String body, Status status, String s3ImageKey, String teamId) {
            super.id(id);
            super.title(title)
                    .status(status)
                    .teamId(teamId)
                    .body(body)
                    .s3ImageKey(s3ImageKey);
        }

        @Override
        public CopyOfBuilder title(String title) {
            return (CopyOfBuilder) super.title(title);
        }

        @Override
        public CopyOfBuilder status(Status status) {
            return (CopyOfBuilder) super.status(status);
        }

        @Override
        public CopyOfBuilder teamId(String teamId) {
            return (CopyOfBuilder) super.teamId(teamId);
        }

        @Override
        public CopyOfBuilder body(String body) {
            return (CopyOfBuilder) super.body(body);
        }

        @Override
        public CopyOfBuilder s3ImageKey(String s3ImageKey) {
            return (CopyOfBuilder) super.s3ImageKey(s3ImageKey);
        }
    }

}