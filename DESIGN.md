# Design System Document

## 1. Overview & Creative North Star: "Kinetic Precision"

This design system is built to move. We are moving away from the static, boxy layouts of traditional fitness trackers and toward **Kinetic Precision**. This North Star focuses on the intersection of raw athletic energy and high-end data visualization.

The aesthetic is "Dark Mode Editorial." By utilizing a high-contrast palette of electric lime and deep charcoals, we create an environment that feels like a premium, dimly lit training facility. We break the "template" look by using intentional asymmetry—letting typography bleed off-grid and using overlapping "glass" containers to create a sense of forward momentum. This is not just an app; it is a high-performance instrument.

---

## 2. Colors & Surface Philosophy

The palette is rooted in deep obsidian tones (`surface`) to minimize eye strain and maximize the "pop" of our energy colors.

### The "No-Line" Rule
**Borders are forbidden.** We do not use 1px solid lines to separate content. Structural integrity is achieved through "Tonal Stepping." To separate a section, shift the background from `surface` (#0e0e0e) to `surface-container-low` (#131313). This creates a sophisticated, seamless transition that feels like a single cohesive object rather than a collection of boxes.

### Surface Hierarchy & Nesting
Treat the UI as a series of physical layers. Use the following hierarchy to define depth:
* **Base Layer:** `surface` (#0e0e0e)
* **Section Layer:** `surface-container-low` (#131313)
* **Interactive Cards:** `surface-container` (#1a1a1a) or `surface-container-high` (#20201f)
* **Floating Elements:** `surface-bright` (#2c2c2c) with glassmorphism.

### The "Glass & Gradient" Rule
Flat color is the enemy of premium design.
* **Signature CTAs:** Do not use flat `#f3ffca`. Apply a subtle linear gradient from `primary` (#f3ffca) to `primary-container` (#cafd00) at a 135-degree angle. This adds "soul" and a sense of metallic sheen.
* **Glassmorphism:** For floating navigation bars or stat overlays, use `surface-container-highest` at 70% opacity with a `20px` backdrop-blur.

---

## 3. Typography: The Editorial Strength

We use a dual-typeface system to balance technical precision with aggressive energy.

* **Display & Headlines (Lexend):** This is our "Power" font. Use `display-lg` and `headline-lg` for PRs (Personal Records), daily goals, and high-impact motivation. Lexend’s geometric clarity conveys strength.
* **Body & Labels (Inter):** Our "Precision" font. Inter handles the heavy lifting of workout logs and data metrics. Its neutral tone ensures readability even during high-intensity movement.

**Editorial Rule:** Use `display-md` for numerical data (e.g., heart rate) and pair it immediately with a `label-sm` in `on-surface-variant` (#adaaaa) for the unit (e.g., BPM) to create a high-end, staggered typographic lockup.

---

## 4. Elevation & Depth: Tonal Layering

Traditional drop shadows are too "software-standard." We use **Ambient Glows** and **Tonal Layering**.

* **The Layering Principle:** To lift a card, do not add a shadow. Instead, place a `surface-container-high` card on top of a `surface-container-lowest` background. The shift in value provides all the affordance necessary.
* **Ambient Shadows:** If an element must float (like a "Start Workout" button), use a shadow color derived from the element itself. For a primary button, use a 15% opacity `primary` shadow with a `24px` blur.
* **The "Ghost Border" Fallback:** If a boundary is strictly required for accessibility, use the `outline-variant` (#484847) at **15% opacity**. It should be felt, not seen.

---

## 5. Components

### Buttons (The Kinetic Triggers)
* **Primary:** Rounded `full` (9999px). Gradient fill (`primary` to `primary-container`). Text color: `on_primary` (#516700). Bold uppercase `label-md`.
* **Secondary:** Rounded `full`. Background: `surface-container-highest`. Ghost border (15% opacity `outline`).
* **Tertiary:** No background. `primary` text with a 2px underline spaced `1.5` (0.375rem) below the baseline.

### Data Visualization (The Pulse)
* **Progress Rings:** Use `primary` (#f3ffca) for the active track and `surface-container-highest` (#262626) for the unfilled track.
* **Intensity Bars:** Use a gradient transition from `primary` (low intensity) to `secondary` (#ff734a) (peak intensity) to visually represent effort.

### Cards & Lists
* **Forbid Dividers:** Never use a horizontal line to separate list items. Use a `4` (1rem) vertical spacing gap or alternate background tones between `surface-container-low` and `surface-container-high`.
* **Content Padding:** Always use a minimum of `5` (1.25rem) internal padding for cards to ensure the "Editorial Breathing Room."

### Performance Inputs
* **Text Fields:** Use `surface-container-highest` with a `md` (0.75rem) corner radius. On focus, the ghost border should increase to 100% opacity of `primary`.

---

## 6. Do’s and Don’ts

### Do:
* **Do** use asymmetrical layouts. Align a headline to the far left and the supporting data to the far right with a large whitespace gap.
* **Do** use `primary` sparingly. It is a "laser pointer" for the eye. If everything is lime, nothing is important.
* **Do** use `rounded-xl` (1.5rem) for large dashboard containers to soften the technical feel.

### Don’t:
* **Don’t** use pure black (#000000) for backgrounds. It kills the depth of the tonal layering. Use `surface` (#0e0e0e).
* **Don’t** use standard 1px borders. They make the app look like a spreadsheet.
* **Don’t** use "Drop Shadows" with black opacity. Always tint shadows with the background or the element's primary hue.
* **Don’t** crowd the UI. If a screen feels full, increase the spacing scale by one increment (e.g., move from `8` to `10`).

---

## 7. Signature Element: The "Active State" Glow
Whenever a user is in an active workout state, apply a subtle, blurred `primary` glow to the edges of the screen (5% opacity). This creates an "immersive environment" that signals to the user they are now in performance mode, moving the app from a tool to an experience.