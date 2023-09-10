package luat.detest.utils;

import java.util.Optional;

public class common {
    public static boolean isPresent(Optional ... optionals){
        for (Optional op:optionals) {
            if(!op.isPresent()){
                return false;
            }
        }
        return true;
    }
}
