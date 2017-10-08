/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task.esw.vantibolli.validators;

/**
 *
 * @author mohammad
 * @param <E>
 */
public interface DataValidator<E> {

    /**
     *
     * @param entity
     * @throws Exception
     */
    public void validate(E entity) throws Exception;
}
