package com.example.a30daysapp

import android.animation.ValueAnimator
import android.content.res.Configuration
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var tipsList: ArrayList<Tip>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)

        tipsList = arrayListOf(
            Tip(1, "Let Your Hand Move", "This is all about freeing yourself from judgment. Don’t overthink; let your hand guide you across the blank page, exploring curves, shapes, and textures. You might end up with something chaotic, but it’s about embracing spontaneity.", "Now try this in reverse—draw with your non-dominant hand! See how different the lines and shapes feel.", R.drawable.art_tip_image1),
            Tip(2, "Explore Color Harmony", "Colors have a powerful effect on mood. Start by choosing a few colors that naturally appeal to you. Consider how different combinations create balance or tension. Play with monochromatic schemes, or try contrasting hues to evoke different emotions.","Try working in black and white first, then slowly add color to specific areas for emphasis.", R.drawable.art_tip_image2),
            Tip(3, "Mindful Sketching", "Slow down your process. Pay attention to each pencil stroke, how it feels on the paper, and the sound it makes. This mindful approach can help you connect more deeply with the art you’re creating, making it a meditative practice.","Close your eyes and draw. This will shift your focus from sight to feel.", R.drawable.art_tip_image3),
            Tip(4, "Create a Character", "Begin with a simple silhouette or outline. Ask yourself: Who are they? What do their features say about their personality or history? Think about what makes them unique—whether it’s an exaggerated feature or a subtle quirk.","Now give your character a background story in one sentence and add a feature that reflects it.", R.drawable.art_tip_image4),
            Tip(5, "Find Inspiration in Nature", "Nature is full of inspiration, from the delicate veins in leaves to the complex textures of bark. Take a short walk and gather reference images or sketches. Don’t aim for perfection—just capture the essence of what you see.", "Now, create a hybrid—combine elements from two different natural objects into one design.", R.drawable.art_tip_image5),
            Tip(6, "Reimagine an Object", "Pick something ordinary, like a coffee mug or a lamp, and draw it from an angle you normally wouldn’t. How does the perspective change your perception of the object? Is it still recognizable, or does it become something entirely different?","Draw this object as if it belonged in another era or world.", R.drawable.art_tip_image6),
            Tip(7, "Capture a Moment", "Think about a fleeting moment in time that has stuck with you. It could be anything from a sunset to a quiet conversation. Focus on the mood or feeling rather than the exact details. How can you capture the essence of that moment in your sketch?","Use only one color to evoke the mood of the moment.", R.drawable.art_tip_image7),
            Tip(8, "Draw an Imaginary Place", "Imagine a place that doesn’t exist, somewhere your mind has wandered to before. Whether it’s a dreamy landscape or a futuristic city, let your imagination run free. Don’t worry about making it realistic—focus on the atmosphere.","Now create a companion piece—a close-up of a small detail in your imaginary place.", R.drawable.art_tip_image8),
            Tip(9, "Recreate a Favorite Scene", "Choose a scene from a book, movie, or memory that resonates with you. Instead of trying to copy it exactly, interpret it through your own artistic lens. How would you portray the mood, characters, or setting differently?","Now depict the same scene, but from a different character’s perspective.", R.drawable.art_tip_image9),
            Tip(10, "Create a Moodboard", "Gather images, colors, and textures that inspire you. This could be digital or physical. The goal is to create a visual representation of your current artistic mood or project. Let it inform your next piece.","Now take one item from your moodboard and create a full piece inspired solely by that element.", R.drawable.art_tip_image10),
            Tip(11, "Focus on Light and Shadow", "Mastering light and shadow can elevate even the simplest drawing. Start with a basic shape and light it from different angles. Practice creating depth with both subtle and dramatic shadows.","Try using a single light source and experiment with casting long, dramatic shadows.", R.drawable.art_tip_image11),
            Tip(12, "Experiment with Abstract", "Let go of traditional forms and dive into abstraction. Focus on shapes, colors, and composition rather than recognizable objects. This will free you from the constraints of realism and allow you to focus purely on aesthetics.","Choose a specific emotion and try to express it using only abstract shapes and lines.", R.drawable.art_tip_image12),
            Tip(13, "Explore Textures", "Texture adds tactile interest to your artwork. Experiment with different mediums like charcoal, watercolor, or even physical textures like sand or fabric. See how each texture changes the feeling of your piece.","Now try mixing an unconventional material—like sand or string—into your artwork.", R.drawable.art_tip_image13),
            Tip(14, "Perspective Challenge", "Try shifting your viewpoint dramatically. Draw something from a high bird’s-eye view or a low worm’s-eye view. How does the perspective change the way the object or scene feels?", "Now draw the same scene from a human eye-level perspective and compare how the energy shifts.", R.drawable.art_tip_image14),
            Tip(15, "Combine Mediums", "Take two different art mediums and blend them in a single piece. For example, try mixing ink with watercolor, or pencil with digital media. See how the different textures and techniques influence each other.","Experiment with blending traditional and digital art techniques to see what new effects you can create.", R.drawable.art_tip_image15),
            Tip(16, "Quick Sketches", "Set a timer for 5 minutes and sketch as many gesture drawings as possible. Focus on capturing the movement and essence of the subject, not the details. This exercise sharpens your ability to see form quickly.","Reduce your time to 1 minute per sketch to push your speed and confidence.", R.drawable.art_tip_image16),
            Tip(17, "Create Dynamic Compositions", "Composition is key to guiding the viewer’s eye. Play with leading lines, negative space, and the rule of thirds. Think about how to create movement and balance in your composition.","Try breaking the rules—create a composition that feels intentionally off-balance or chaotic.", R.drawable.art_tip_image17),
            Tip(18, "Balance in Art", "Balance can be symmetrical or asymmetrical. Try creating a piece that plays with both—find harmony in opposing elements. How does each type of balance affect the overall feeling of your piece?", "Flip your drawing upside down and see if it still feels balanced.", R.drawable.art_tip_image18),
            Tip(19, "Patterns and Repetition", "Patterns can create a rhythm in your artwork. Use repetition to build complexity. Whether it’s geometric or organic, let the pattern develop naturally and see how it influences the flow of your composition.","Now take one element from your pattern and blow it up as a singular focus.", R.drawable.art_tip_image19),
            Tip(20, "Art Through Different Eras", "Choose an art movement that inspires you, such as Impressionism or Surrealism, and create a piece in that style. Think about the techniques and philosophies behind that movement and how you can apply them to your own work.","Try combining two distinct art movements in one piece to see how they blend or clash.",R.drawable.art_tip_image20),
            Tip(21, "Design a Fictional World", "Sketch the map or the main landmarks of an imagined place, keeping it grounded in artistic techniques. Think about the geography—mountains, rivers, cities—and how they influence the world’s culture and inhabitants. ","Now add in a mysterious landmark or location—something unusual that makes people wonder what could have happened there.", R.drawable.art_tip_image21),
            Tip(22, "Cultural Inspiration", "Draw inspiration from a specific culture’s art. Explore how different cultures approach patterns, designs, and symbols, focusing on the meanings behind these elements. Study the art of indigenous cultures, historical designs, or religious symbolism to inform your own piece.","Mix elements from two different cultures to create something entirely new and unique.", R.drawable.art_tip_image22),
            Tip(23, "Tell a Story with Art", "Try illustrating a simple story with just one image. What’s happening in this moment? Is it a pivotal point in a character’s life? Use body language, expression, and the setting to hint at what happened before and after this moment.","Create a companion piece showing the aftermath or resolution of this scene.", R.drawable.art_tip_image23),
            Tip(24, "Express Emotions Through Color", "Create a piece where color is the main tool for conveying emotion. Choose your colors deliberately: cool blues and greens for calm or sadness, fiery reds and oranges for passion or anger. Let the intensity of your palette express the mood.","Now do the opposite—try expressing the same emotion using only grayscale or muted tones.", R.drawable.art_tip_image24),
            Tip(25, "Unique Architecture", "Design a building or space. Think about how form and function come together in your design. Is it futuristic, organic, or inspired by nature? Consider the purpose of the structure and how its design serves those who use it.","Now take one feature of this building—like a window, door, or roof—and expand it into a full piece of art, exploring its details.", R.drawable.art_tip_image25),
            Tip(26, "Beautiful Transitions", "Depict a scene where a transition is happening. Capture the feeling of change, the subtle shift in light, color, and atmosphere as the world moves from one state to another. Transitions can bring a sense of movement and time to your artwork.","Create a companion piece showing the same scene at its opposite—like winter becoming spring or dawn instead of dusk.", R.drawable.art_tip_image26),
            Tip(27, "Create a Creature", "Design an animal or creature that doesn’t exist. Focus on anatomy and features that make it unique, whether it’s inspired by real animals or entirely fantastical. Consider its habitat, diet, and behavior—how do these factors influence its physical form?","Now imagine the environment it lives in—draw a quick sketch of its natural habitat or ecosystem.", R.drawable.art_tip_image27),
            Tip(28, "Symbolism in Art", "Add subtle symbols to a piece that hint at a deeper meaning. Think about how symbols can add layers to your work. Whether it’s through objects, colors, or gestures, let the symbols create a hidden narrative.","Create a key or guide that explains each symbol’s meaning, but keep it secret—let only those who search for it find the deeper meaning.", R.drawable.art_tip_image28),
            Tip(29, "Alternate Realities", "Depict a subject in two different settings or styles, showing how context changes the interpretation. It could be a character drawn in both a modern and ancient setting, or a scene shown in both a realistic and abstract style. See how it transforms the mood and meaning.","Now mix the two realities together in one scene—combine elements of both to create a unique hybrid world.", R.drawable.art_tip_image29),
            Tip(30, "The Final Project", "Bring together your favorite techniques from the past 30 days into a final artwork. Let this piece reflect your artistic journey. Whether it’s a character, landscape, or abstract concept, use the skills you’ve developed to create something that showcases your growth and creativity.","Now push yourself further—experiment with a technique or style you haven’t tried before to challenge your boundaries.", R.drawable.art_tip_image30),
        )

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = TipsAdapter(tipsList, isDarkMode())

        animateBackground()
    }

    private fun animateBackground() {
        val colors = intArrayOf(
            0xFF141342.toInt(),
            0xFF213492.toInt(),
            0xFFFF6B47.toInt()
        )

        val gradientDrawable = GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, colors)
        findViewById<FrameLayout>(R.id.frameLayout).background = gradientDrawable

        val animator = ValueAnimator.ofFloat(0f, 1f)
        animator.addUpdateListener { animation ->
            val fraction = animation.animatedValue as Float
            gradientDrawable.colors = intArrayOf(
                interpolateColor(colors[0], colors[1], fraction),
                interpolateColor(colors[1], colors[2], fraction)
            )
        }
        animator.duration = 5000
        animator.repeatCount = ValueAnimator.INFINITE
        animator.repeatMode = ValueAnimator.REVERSE
        animator.start()
    }

    private fun interpolateColor(color1: Int, color2: Int, fraction: Float): Int {
        val a = (Color.alpha(color1) + fraction * (Color.alpha(color2) - Color.alpha(color1))).toInt()
        val r = (Color.red(color1) + fraction * (Color.red(color2) - Color.red(color1))).toInt()
        val g = (Color.green(color1) + fraction * (Color.green(color2) - Color.green(color1))).toInt()
        val b = (Color.blue(color1) + fraction * (Color.blue(color2) - Color.blue(color1))).toInt()
        return Color.argb(a, r, g, b)
    }

    private fun isDarkMode(): Boolean {
        return resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK == Configuration.UI_MODE_NIGHT_YES
    }
}
