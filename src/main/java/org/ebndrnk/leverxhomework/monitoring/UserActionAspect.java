package org.ebndrnk.leverxhomework.monitoring;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.ebndrnk.leverxhomework.monitoring.send.UserActionSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UserActionAspect {
    private final UserActionSender userActionSender;
    private final Logger log = LoggerFactory.getLogger(UserActionAspect.class);


    public UserActionAspect(UserActionSender userActionSender) {
        this.userActionSender = userActionSender;
    }

    /**
     * Method triggered before the execution of methods annotated with {@link UserAction}.
     * Logs user actions and sends them to the monitoring service.
     *
     * The method is also equipped with error handling,
     * which allows you not to change
     * the course of the program even if there
     * are failures in your aspect
     *
     * @param userAction annotation containing information about the type of user action.
     * @param joinPoint information about method parameters annotated with {@link UserAction}.
     */
    @After("@annotation(userAction)")
    public void logUserAction(JoinPoint joinPoint, UserAction userAction) {
        try {
            PossibleActions possibleActions = userAction.actionType();
            userActionSender.send(joinPoint, possibleActions);
            //There can be an infinite amount of logic here
        } catch (Exception e) {
            // Logging the exception and continuing program execution
            log.error("Error while sending user action: {}", e.getMessage());
        }
    }


}
