# BestViewDistance
A view distance plugin for Paper. Created to boost ping/tps and view distance.

## How it works ?
This plugin chooses the **best view distance for your players**.
The **view distance** is calculated based on your ping and the **TPS of the server**.
If the TPS are low, the view distance is reduced by a percentage called "*reduction indice*".
The reduction indice changes according to the TPS of the server.

This plugin **reduces players lag**, reduces players **ping** and **optimizes** your server a **better view distance**.

## Dependencies
Please download Paper !
https://papermc.io
It's better than spigot and bukkit.
Also provide you a lot of optimizations and options.
[WARNING] ProtocolLib is needed ONLY for 1.12.X !

## Commands / Permissions
```
/view server => Get reduction indice.
/view tps => Get server's tps.
/view ping <player> => Get player ping.
/view <player> => Get player actual view distance and his max view distance.
/view => Get help

Permission : "view.check"

/view reload => Reload plugin config. Need "view.reload"
/vdist => Allows your players to see their own view distance. Need "view.info"

Permission for update checker : "view.update"

Bypass algorithm : "view.set.x" (3 to 32)
(Example : view.set.15 set a view dist of 15 chunks)
```

## Config
```
#   ╔╗ ┌─┐┌─┐┌┬┐  ╦  ╦┬┌─┐┬ ┬  ╔╦╗┬┌─┐┌┬┐┌─┐┌┐┌┌─┐┌─┐
#   ╠╩╗├┤ └─┐ │   ╚╗╔╝│├┤ │││   ║║│└─┐ │ ├─┤││││  ├┤
#   ╚═╝└─┘└─┘ ┴    ╚╝ ┴└─┘└┴┘  ═╩╝┴└─┘ ┴ ┴ ┴┘└┘└─┘└─┘
#       - Get a Better View Distance, By LXCT. -
#=======================================================
# (Don't change Performances unless You Know what you're doing !)
# Need some help to config ?
# Read this :
#
#
# ViewDistance:
#   Min: 4 # Min View Distance. Keep it above 4.
#   Max: 16 # Max View Distance. Player can't get above 32.
#   AFK : 3 # View Distance of "AFK" players. You can't assign a value less than 3.
#   OnLogin: 4 # View Distance assigned on login. I advise you to set the same value as Min
#   CalculationDelay: 2 # Delay between ASYNC calculations. Keep it above 1. NEED RESTART, DOES NOT AFFECT PERFORMANCES.
#   SetViewDelay: 15 # Delay between applying calculations. Keep it above 5. A little number will make view distance change faster. NEED RESTART, AFFECT PERFORMANCES.
# Performances:
#   PingForReduction: 1000 # If your ping is higher than this value, then your view distance will be reduced. Keep it above 400.
#   PingForAugmentation: 90 # If your ping is less than this value, then your view distance will be increased. Keep it below 100.
#   TPSLimit: 19.5 # If the tps are above this value, the ReductionIndice is reduced. If the tps are below this value, the ReductionIndice will increase.
#   TPSChangeIndice: 0.05 # How much the reduction indice will be decreased/increased par calculations. Keep this value between 0.1 and 0.01
#   MaxReductionIndice: 0.75 # Maximum value of the reduction indice.
#   AFKTimer : 90 # Seconds before getting "AFK" and get his view distance reduced to "Min" value. Keep this value over 60. (Doesn't affect gameplay)
# Other:
#   HideVdistLine4: false # Hide vdist.line4 (in messages.yml) when players uses /vdist
#   CheckUpdate: true # You should keep this to true. It check if your plugins version is the latest. THIS DOES NOT IMPACT PERFORMANCES, NEED RESTART
#   Metrics: true # Please keep this to true. Metrics is anonymous and it helps developers stay motivated. THIS DOES NOT IMPACT PERFORMANCES, NEED RESTART
#   SafePing: 1 # Minimum ping required for calculations. Set it to 0 or -1 for local hosting. Keep this value below 1
#
# Please restart your server the first time you're using this plugin. Don't reload.
#
# Problems ? Performance issues ? Wanna say thanks ? ;)
# Add me on Discord ! Lxct#9971
#

ViewDistance:
  Min: 4
  Max: 16
  AFK: 3
  OnLogin: 4
  CalculationsDelay: 2
  SetViewDelay: 15
Performances:
  PingForReduction: 1000
  PingForAugmentation: 90
  TPSLimit: 19.5
  TPSChangeIndice: 0.05
  MaxReductionIndice: 0.75
  AFKTimer: 90
Other:
  HideVdistLine4: false
  CheckUpdates: true
  Metrics: true
  SafePing: 1
```

+ Messages.yml File.

## Compilation
Bash/Zsh linux terminal :

```
git clone https://github.com/Lxct/BestViewDistance.git
cd BestViewDistance
sudo mvn clean install
```
The jar is in the `target/` folder.

## Contact
Add me on Discord => Lxct#9971
I'd like to hear your comments ! <3


## Infos
Spigot Link : [https://www.spigotmc.org/resources/best-view-distance.61963/](https://www.spigotmc.org/resources/best-view-distance.61963/)
Github Link : [https://github.com/Lxct/BestViewDistance](https://github.com/Lxct/BestViewDistance)
