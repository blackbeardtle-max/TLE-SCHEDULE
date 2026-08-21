#define MyAppName "TLE SCHEDULE"
#define MyAppVersion "1.0.0"
#define MyAppPublisher "Tri Lautan Emas"
#define MyAppExeName "TLE-SCHEDULE.exe"

[Setup]
AppId={{4AC1E8E8-75DF-4E8D-B5DA-2ED2E546E6B7}
AppName={#MyAppName}
AppVersion={#MyAppVersion}
AppPublisher={#MyAppPublisher}
DefaultDirName={autopf}\TLE SCHEDULE
DefaultGroupName=TLE SCHEDULE
OutputDir=installer-output
OutputBaseFilename=TLE-SCHEDULE-Windows-Setup
Compression=lzma
SolidCompression=yes
WizardStyle=modern
SetupIconFile=tle.ico
UninstallDisplayIcon={app}\{#MyAppExeName}
ArchitecturesInstallIn64BitMode=x64compatible

[Files]
Source: "publish\{#MyAppExeName}"; DestDir: "{app}"; Flags: ignoreversion

[Icons]
Name: "{autoprograms}\TLE SCHEDULE"; Filename: "{app}\{#MyAppExeName}"
Name: "{autodesktop}\TLE SCHEDULE"; Filename: "{app}\{#MyAppExeName}"; Tasks: desktopicon

[Tasks]
Name: "desktopicon"; Description: "Create a &desktop shortcut"; GroupDescription: "Additional icons:"; Flags: unchecked

[Run]
Filename: "{app}\{#MyAppExeName}"; Description: "Open TLE SCHEDULE"; Flags: nowait postinstall skipifsilent
