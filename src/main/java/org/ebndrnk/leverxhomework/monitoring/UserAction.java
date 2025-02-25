package org.ebndrnk.leverxhomework.monitoring;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Аннотация, используемая для обозначения действий пользователей, которые должны быть зафиксированы.
 * Эта аннотация применяется к методам, которые выполняют действия, требующие мониторинга.
 *
 * @see PossibleActions
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UserAction {
    /**
     * Тип действия пользователя, который будет зафиксирован.
     *
     * @return тип действия из перечисления {@link PossibleActions}.
     */
    PossibleActions actionType();
}