package ie.lochlann.entities;

// This is not a class, its a RECORD
// A record is a restricted class, less functionality
// Carries data in one direction only
// Built-in functions eg. getters, hashcode etc.
// Only use this to populate data for retrieval
public record Result(String directorFname, String directorLname, String movieTitle) {};