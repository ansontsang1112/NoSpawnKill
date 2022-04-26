**Most update version will be found at https://plugin.hypernite.com/**

A plugin for preventing any respawn kill actions.

#### Installation
1. Download and put the plugin into /plugins/
2. Restart or load the plugin into the server
3. Edit the configuration in the plugin
4. Happy to use

#### Requirement
**Java 16** or above.<br>
Minecraft Server with **1.17 or above**.

#### config.yml
```yml
# No Spawn Kill Configuration

settings:
  protected-duration: 30 #In Seconds

message:
  prefix: "&b&l[NSK]&f"
  start-respawn: "Spawn Kill Protection enabled for &a%duration%&f seconds." #Please don't change %duration%
  end-protection: "Protection period done. Please try you best to survival in the server!"
```
