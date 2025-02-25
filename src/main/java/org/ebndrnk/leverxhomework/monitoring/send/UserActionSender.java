package org.ebndrnk.leverxhomework.monitoring.send;

import org.aspectj.lang.JoinPoint;
import org.ebndrnk.leverxhomework.monitoring.PossibleActions;


public interface UserActionSender {
    void send(JoinPoint joinPoint, PossibleActions possibleActions);
}
