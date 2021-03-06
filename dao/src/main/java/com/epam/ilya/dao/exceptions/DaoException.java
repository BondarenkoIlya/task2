package com.epam.ilya.dao.exceptions;

/**
 * Class covers all exceptions arose in Dao layer
 *
 * @author Ilya_Bondarenko
 */
public class DaoException extends Exception {

    /**
     * Constructor call super class's constructor with the same parameters for throwing up
     *
     * @param message including information about exception
     * @param e       caught exception
     */
    public DaoException(String message, Exception e) {
        super(message, e);
    }

    /**
     * Constructor call super class's constructor with the same parameters for throwing up
     *
     * @param message including information about exception
     */
    public DaoException(String message) {
        super(message);
    }
}
