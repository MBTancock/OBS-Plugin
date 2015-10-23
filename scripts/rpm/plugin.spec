# Prevent re-packaging - 1. It can possible break a jar signed jar 2. Slows down the build process
%define __jar_repack 0

Prefix: /opt/avid
Name: %{PROJECT_NAME}
Summary: %{PROJECT_SUMMARY}
Vendor: Avid
Version: %{PROJECT_VERSION}
Release: 1
Group: avid-interplay-central	
BuildArch: noarch
License: Commercial
requires: avid-interplay-central-core

%description

%{PROJECT_DESC}

%prep


%build

%clean

%install

mkdir -p "$RPM_BUILD_ROOT/opt/avid/avid-interplay-central/%{PLUGIN_SUB_PATH}"
cd "$RPM_BUILD_ROOT/opt/avid/avid-interplay-central/%{PLUGIN_SUB_PATH}"
cp %_sourcedir/*.jar .

mkdir -p "$RPM_BUILD_ROOT/opt/avid/avid-interplay-central/profiles"
cd "$RPM_BUILD_ROOT/opt/avid/avid-interplay-central/profiles"
cp -R %_sourcedir/profiles/*.yml .

%pre

%post


%preun

%postun

%files
/opt/avid/avid-interplay-central/%{PLUGIN_SUB_PATH}
/opt/avid/avid-interplay-central/profiles

%defattr(-,root,root,-)

%doc

%changelog
