/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newBean;

import javax.ejb.Local;

/**
 *
 * @author 695923
 */
@Local
public interface TwitSLSBLocal {
    void addTwit(int channel, String twit);
    void delTwit(int twit);
}
