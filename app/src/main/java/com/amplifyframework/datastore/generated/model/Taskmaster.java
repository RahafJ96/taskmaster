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

/** This is an auto generated class representing the TaskMaster type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "Taskmasters", authRules = {
        @AuthRule(allow = AuthStrategy.PUBLIC, operations = { ModelOperation.CREATE, ModelOperation.UPDATE, ModelOperation.DELETE, ModelOperation.READ })
})
public final class Taskmaster implements Model {
    public static final QueryField ID = field("Taskmaster", "id");
    public static final QueryField TITLE = field("Taskmaster", "title");
    public static final QueryField BODY = field("Taskmaster", "body");
    public static final QueryField STATUS = field("Taskmaster", "status");
    private final @ModelField(targetType="ID", isRequired = true) String id;
    private final @ModelField(targetType="String", isRequired = true) String title;
    private final @ModelField(targetType="String") String body;
    private final @ModelField(targetType="Status", isRequired = true) Status status;
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

    public Temporal.DateTime getCreatedAt() {
        return createdAt;
    }

    public Temporal.DateTime getUpdatedAt() {
        return updatedAt;
    }

    private Taskmaster(String id, String title, String body, Status status) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.status = status;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if(obj == null || getClass() != obj.getClass()) {
            return false;
        } else {
            Taskmaster taskmaster = (Taskmaster) obj;
            return ObjectsCompat.equals(getId(), taskmaster.getId()) &&
                    ObjectsCompat.equals(getTitle(), taskmaster.getTitle()) &&
                    ObjectsCompat.equals(getBody(), taskmaster.getBody()) &&
                    ObjectsCompat.equals(getStatus(), taskmaster.getStatus()) &&
                    ObjectsCompat.equals(getCreatedAt(), taskmaster.getCreatedAt()) &&
                    ObjectsCompat.equals(getUpdatedAt(), taskmaster.getUpdatedAt());
        }
    }

    @Override
    public int hashCode() {
        return new StringBuilder()
                .append(getId())
                .append(getTitle())
                .append(getBody())
                .append(getStatus())
                .append(getCreatedAt())
                .append(getUpdatedAt())
                .toString()
                .hashCode();
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("Taskmaster {")
                .append("id=" + String.valueOf(getId()) + ", ")
                .append("title=" + String.valueOf(getTitle()) + ", ")
                .append("body=" + String.valueOf(getBody()) + ", ")
                .append("status=" + String.valueOf(getStatus()) + ", ")
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
                null
        );
    }

    public CopyOfBuilder copyOfBuilder() {
        return new CopyOfBuilder(id,
                title,
                body,
                status);
    }
    public interface TitleStep {
        StatusStep title(String title);
    }


    public interface StatusStep {
        BuildStep status(Status status);
    }


    public interface BuildStep {
        Taskmaster build();
        BuildStep id(String id);
        BuildStep body(String body);
    }


    public static class Builder implements TitleStep, StatusStep, BuildStep {
        private String id;
        private String title;
        private Status status;
        private String body;
        @Override
        public Taskmaster build() {
            String id = this.id != null ? this.id : UUID.randomUUID().toString();

            return new Taskmaster(
                    id,
                    title,
                    body,
                    status);
        }

        @Override
        public StatusStep title(String title) {
            Objects.requireNonNull(title);
            this.title = title;
            return this;
        }

        @Override
        public BuildStep status(Status status) {
            Objects.requireNonNull(status);
            this.status = status;
            return this;
        }

        @Override
        public BuildStep body(String body) {
            this.body = body;
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
        private CopyOfBuilder(String id, String title, String body, Status status) {
            super.id(id);
            super.title(title)
                    .status(status)
                    .body(body);
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
        public CopyOfBuilder body(String body) {
            return (CopyOfBuilder) super.body(body);
        }
    }

}