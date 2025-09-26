package com.example.studentsocietymanagementsystem;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.util.HashMap;
import java.util.LinkedList;


// ParticipantNode class
class ParticipantNode {
    String data;
    ParticipantNode left, right;

    public ParticipantNode(String data) {
        this.data = data;
        left = right = null;
    }
}

// ParticipantTree class
class ParticipantTree {
    private ParticipantNode root;

    public void addParticipant(String data) {
        root = addRecursive(root, data);
    }

    private ParticipantNode addRecursive(ParticipantNode node, String data) {
        if (node == null) {
            return new ParticipantNode(data);
        }
        if (data.compareTo(node.data) < 0) {
            node.left = addRecursive(node.left, data);
        } else if (data.compareTo(node.data) > 0) {
            node.right = addRecursive(node.right, data);
        }
        return node;
    }

    public String getAllParticipants() {
        StringBuilder result = new StringBuilder();
        traverseInOrder(root, result);
        return result.toString();
    }

    private void traverseInOrder(ParticipantNode node, StringBuilder result) {
        if (node != null) {
            traverseInOrder(node.left, result);
            result.append(node.data).append("\n");
            traverseInOrder(node.right, result);
        }
    }
}

// Event class
class Event {
    private String id;
    private String name;
    private String date;

    public Event(String id, String name, String date) {
        this.id = id;
        this.name = name;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public void updateEvent(String name, String date) {
        this.name = name;
        this.date = date;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Date: " + date;
    }
}
// Member class
class Member {
    private String id;
    private String name;
    private String role;
    private String contact;

    public Member(String id, String name, String role, String contact) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.contact = contact;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public String getContact() {
        return contact;
    }

    public void updateMember(String name, String role, String contact) {
        this.name = name;
        this.role = role;
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Role: " + role + ", Contact: " + contact;
    }
}

public class GUI extends Application {
    private StudentSocietyManagementSystem system = new StudentSocietyManagementSystem();
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Student Society Management System");

        // Main layout
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10));

        // Buttons
        Button addMemberButton = new Button("Add Member");
        Button addEventButton = new Button("Add Event");
        Button viewParticipantsButton = new Button("View Participants");

        // Add Member Action
        addMemberButton.setOnAction(e -> {
            TextInputDialog dialog = new TextInputDialog();
            dialog.setHeaderText("Add Member");
            dialog.setContentText("Enter Member ID:");
            String id = dialog.showAndWait().orElse("");

            dialog.setContentText("Enter Member Name:");
            String name = dialog.showAndWait().orElse("");

            dialog.setContentText("Enter Member Role:");
            String role = dialog.showAndWait().orElse("");

            dialog.setContentText("Enter Member Contact:");
            String contact = dialog.showAndWait().orElse("");

            if (!id.isEmpty() && !name.isEmpty() && !role.isEmpty() && !contact.isEmpty()) {
                system.addMember(new Member(id, name, role, contact));
                showAlert(Alert.AlertType.INFORMATION, "Member Added Successfully!");
            }
        });

        // Add Event Action
        addEventButton.setOnAction(e -> {
            TextInputDialog dialog = new TextInputDialog();
            dialog.setHeaderText("Add Event");
            dialog.setContentText("Enter Event ID:");
            String id = dialog.showAndWait().orElse("");

            dialog.setContentText("Enter Event Name:");
            String name = dialog.showAndWait().orElse("");

            dialog.setContentText("Enter Event Date:");
            String date = dialog.showAndWait().orElse("");

            if (!id.isEmpty() && !name.isEmpty() && !date.isEmpty()) {
                system.addEvent(new Event(id, name, date));
                showAlert(Alert.AlertType.INFORMATION, "Event Added Successfully!");
            }
        });

        // View Participants Action
        viewParticipantsButton.setOnAction(e -> {
            ChoiceDialog<String> eventDialog = new ChoiceDialog<>();
            for (Event event : system.getEvents()) {
                eventDialog.getItems().add(event.getId());
            }
            eventDialog.setHeaderText("Select Event");
            eventDialog.setContentText("Choose an Event ID:");

            String selectedEvent = eventDialog.showAndWait().orElse(null);
            if (selectedEvent != null) {
                String participants = system.getParticipants(selectedEvent);
                showAlert(Alert.AlertType.INFORMATION, "Participants for Event " + selectedEvent + ":\n" + participants);
            }
        });
        layout.getChildren().addAll(addMemberButton, addEventButton, viewParticipantsButton);

        // Scene and Stage
        Scene scene = new Scene(layout, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    private void showAlert(Alert.AlertType type, String message) {
        Alert alert = new Alert(type);
        alert.setContentText(message);
        alert.showAndWait();
    }
    public static void main(String[] args) {
        launch(args);
    }
}


// StudentSocietyManagementSystem class
class StudentSocietyManagementSystem {
    private HashMap<String, Member> members = new HashMap<>();
    private LinkedList<Event> events = new LinkedList<>();
    private HashMap<String, ParticipantTree> eventParticipants = new HashMap<>();

    public void addMember(Member member) {
        members.put(member.getId(), member);
    }

    public void addEvent(Event event) {
        events.add(event);
        eventParticipants.put(event.getId(), new ParticipantTree());
    }

    public void trackParticipation(String eventId, String participantId) {
        ParticipantTree tree = eventParticipants.get(eventId);
        if (tree != null) {
            tree.addParticipant(participantId);
        }
    }

    public LinkedList<Event> getEvents() {
        return events;
    }

    public String getParticipants(String eventId) {
        ParticipantTree tree = eventParticipants.get(eventId);
        return (tree != null) ? tree.getAllParticipants() : "No participants.";
    }
}

