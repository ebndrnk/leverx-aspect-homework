package org.ebndrnk.leverxhomework.monitoring.send;

import org.aspectj.lang.JoinPoint;
import org.ebndrnk.leverxhomework.model.UserDto;
import org.ebndrnk.leverxhomework.monitoring.PossibleActions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


/**
 * depending on the action performed by the user,
 * you may need custom logic; using aspects allows you to encapsulate it all
 */
@Service
public class MockSender implements UserActionSender{
    private final Logger log = LoggerFactory.getLogger(MockSender.class);



    @Override
    public void send(JoinPoint joinPoint, PossibleActions possibleActions) {
        UserDto userDto = null;
        for(Object arg : joinPoint.getArgs()){
            if(arg instanceof UserDto){
                userDto = (UserDto) arg;
            }
        }
        if(userDto != null){
            log.info("User {} was send some information about {}", userDto.getName(), possibleActions);
        }
    }
}
