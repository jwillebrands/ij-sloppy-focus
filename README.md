# Sloppy Focus for IntelliJ

![Build](https://github.com/jwillebrands/ij-sloppy-focus/workflows/Build/badge.svg)
[![Version](https://img.shields.io/jetbrains/plugin/v/19733.svg)](https://plugins.jetbrains.com/plugin/19733)
[![Downloads](https://img.shields.io/jetbrains/plugin/d/19733.svg)](https://plugins.jetbrains.com/plugin/19733)

<!-- Plugin description -->
This plugin brings sloppy focus to your favorite IDE.

Sloppy focus, sometimes called "focus follows mouse", means your focus switches whenever your cursor enters a focusable region. This
plugin enables this behavior for editors and terminals, and, optionally, for any focusable IDE component.
<!-- Plugin description end -->

## Functionality

By default, Sloppy Focus will switch focus to terminals and editors when entering with the mouse.
This behavior can be changed through settings to switch focus to any focusable component.

**Note:** This plugin is still in a very early phase. It 'works on my machine', but has not yet seen much use and has not been
tested properly. There will be bugs and rough edges. Please feel free to
create [bug reports](https://github.com/jwillebrands/ij-sloppy-focus/issues) for usability or compatibility issues.

## Installation

This plugin is provided both as a regular IDE plugin, and as a Flora micro-plugin script.
The Flora plugin currently only supports editors, and will likely not be updated anymore unless I figure out an easy way to bundle
the main plugin.

### Using IDE built-in plugin system

<kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>Marketplace</kbd> > <kbd>Search for "ij-sloppy-focus"</kbd> >
<kbd>Install Plugin</kbd>

Or click the <kbd>Install to IntelliJ</kbd> button on the [plugin page](https://plugins.jetbrains.com/plugin/19733).

### Manually

Download the [latest release](https://github.com/jwillebrands/ij-sloppy-focus/releases/latest) and install it manually using
<kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>⚙️</kbd> > <kbd>Install plugin from disk...</kbd>

### Using [Flora](https://plugins.jetbrains.com/plugin/17669-flora-beta-/)

Download the latest version of sloppy-focus.plugin.kts from
the [releases](https://github.com/jwillebrands/ij-sloppy-focus/releases/latest) page and place it in your project's `.plugins`
folder. Flora should pick it up automatically.
