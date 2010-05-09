/*
 * This file is part of VLCJ.
 *
 * VLCJ is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * VLCJ is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with VLCJ.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * Copyright 2009, 2010 Caprica Software Limited.
 */

package uk.co.caprica.vlcj.check;

import org.apache.log4j.Logger;

import uk.co.caprica.vlcj.check.linux.LinuxEnvironmentChecker;
import uk.co.caprica.vlcj.check.mac.MacEnvironmentChecker;
import uk.co.caprica.vlcj.check.windows.WindowsEnvironmentChecker;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;

/**
 * 
 */
public class EnvironmentCheckerFactory {

  /**
   * Log.
   */
  private static final Logger LOG = Logger.getLogger(EnvironmentCheckerFactory.class);
  
  /**
   * 
   * 
   * @return
   */
  public EnvironmentChecker newEnvironmentChecker() {
    LOG.debug("newEnvironmentChecker()");
    
    EnvironmentChecker environmentChecker;
    
    if(RuntimeUtil.isNix()) {
      environmentChecker = new LinuxEnvironmentChecker();
    }
    else if(RuntimeUtil.isWindows()) {
      environmentChecker = new WindowsEnvironmentChecker();
    }
    else if(RuntimeUtil.isMac()) {
      environmentChecker = new MacEnvironmentChecker();
    }
    else {
      throw new UnsupportedOperationException("Failed to detect operating system");
    }
    
    if(LOG.isDebugEnabled()) {LOG.debug("environmentChecker=" + environmentChecker + ")");}
    
    return environmentChecker;
  }
}
