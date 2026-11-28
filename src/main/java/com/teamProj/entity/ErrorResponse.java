package com.teamProj.entity;

/**
 * Standard JSON error payload for API error responses.
 */
public class ErrorResponse {
    private String error;

    /**
     * Constructs an ErrorResponse with a descriptive message.
     *
     * @param error the error message
     */
    public ErrorResponse(String error) {
        this.error = error;
    }

    /**
     * Gets the error message.
     *
     * @return the error message
     */
    public String getError() {
        return error;
    }

    /**
     * Sets the error message.
     *
     * @param error the error message
     */
    public void setError(String error) {
        this.error = error;
    }
}
