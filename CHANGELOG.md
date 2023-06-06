# Changelog

## [Unreleased]

### Changed

- Improved popup detection. Before only the ActionManager popup stack was checked. Now we also check whether
  the `PopupFactory` is aware of any active popups. This should prevent more popups (e.g. new Angular schematic) from
  being auto-closed due to switching focus.

## [0.4.1] - 2023-05-16

### Added
- Bump compatibility range to include 2023.2

## [0.4.0] - 2022-12-12

### Changed
- Switched to UI DSL v2.
- Switching focus is now prevent when Search Everywhere is active.

## [0.3.0]

### Changed
- Switching focus is now prevented while a context menu is active.

## [0.2.0]

### Added
- Make focus change delay configurable.
- Support switching focus to Terminal windows.
- Allow switching focus to any focusable component. This is configurable through settings. (default: off)

### Changed
- Debounce focus changes by adding a short delay between the mouse enter and switching focus.

## [0.1.1] - 2022-08-24

### Added
- Add custom icon.
- Supports sloppy focus for editor windows.
- Initial plugin version.

[Unreleased]: https://github.com/jwillebrands/ij-sloppy-focus/compare/v0.4.1...HEAD
[0.4.1]: https://github.com/jwillebrands/ij-sloppy-focus/compare/v0.4.0...v0.4.1
[0.4.0]: https://github.com/jwillebrands/ij-sloppy-focus/compare/v0.3.0...v0.4.0
[0.3.0]: https://github.com/jwillebrands/ij-sloppy-focus/compare/v0.2.0...v0.3.0
[0.2.0]: https://github.com/jwillebrands/ij-sloppy-focus/compare/v0.1.1...v0.2.0
[0.1.1]: https://github.com/jwillebrands/ij-sloppy-focus/commits/v0.1.1
