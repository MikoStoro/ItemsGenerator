package com.example.generatorprzedmiotw

import android.net.IpSecManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.solver.widgets.ConstraintAnchor
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.melee_layout.*
import org.jetbrains.anko.toast
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    var weaponAttribute: String = ""
    var weaponDice: String = ""
    var weaponDamage: Int = 0
    var weaponCrit: Int = 0
    var weaponAccuracy: Int = 0
    var weaponWeight: Int = 0


    var wpnDmgCost: Int = 0
    var wpnCritCost: Int = 0
    var wpnAccCost: Int = 0


    var crossbowDamage: Int = 0
    var crossbowReload: Int = 0

    var crossbowDmgCost: Int = 0
    var crossbowReloadSubCost: Int = 0
    var crossbowWeightGain = 2


    var armorDef: Int = 0
    var armorMdef: Int = 0
    var armorDurability: Int = 0
    var armorWeight: Int = 0
    var armorWeightGain: Int = 0

    var armorDefCost: Int = 0
    var armorMdefCost: Int = 0

    var level: Int = 0
    val weightSubCost: Int = 2
    val critIncCost: Int = 2


    var typeVar: String = "Melee weapons"
    var itemVar: String = "Dagger"

    fun assignParameters() {
        when (itemVar) {
            "Dagger" -> {
                weaponAttribute = "Dexterity"
                weaponDice = "K6"
                weaponDamage = 2
                weaponCrit = 3
                weaponAccuracy = 15
                weaponWeight = 1

                wpnAccCost = 2
                wpnCritCost = 3
                wpnDmgCost = 4
            }

            "Staff" -> {
                weaponAttribute = "Dexterity"
                weaponDice = "K6"
                weaponDamage = 2
                weaponCrit = 0
                weaponAccuracy = 13
                weaponWeight = 2

                wpnAccCost = 2
                wpnCritCost = 5
                wpnDmgCost = 4
            }

            "Sabre" -> {
                weaponAttribute = "Dexterity"

                weaponDice = "K8"
                weaponDamage = 2
                weaponCrit = 2
                weaponAccuracy = 10
                weaponWeight = 2

                wpnAccCost = 2
                wpnCritCost = 4
                wpnDmgCost = 5
            }

            "Sword" -> {
                weaponAttribute = "Dexterity/Strength"
                weaponDice = "K8"
                weaponDamage = 3
                weaponCrit = 1
                weaponAccuracy = 10
                weaponWeight = 2

                wpnAccCost = 2
                wpnCritCost = 4
                wpnDmgCost = 5
            }

            "Sword(2H)" -> {
                weaponAttribute = "Dexterity/Strength"

                weaponDice = "K10"
                weaponDamage = 3
                weaponCrit = 1
                weaponAccuracy = 10
                weaponWeight = 3

                wpnAccCost = 2
                wpnCritCost = 4
                wpnDmgCost = 6
            }

            "Katana" -> {
                weaponAttribute = "Dexterity"

                weaponDice = "K8"
                weaponDamage = 2
                weaponCrit = 2
                weaponAccuracy = 10
                weaponWeight = 2

                wpnAccCost = 2
                wpnCritCost = 3
                wpnDmgCost = 5
            }

            "Katana(2H)" -> {
                weaponAttribute = "Dexterity"

                weaponDice = "K10"
                weaponDamage = 2
                weaponCrit = 2
                weaponAccuracy = 10
                weaponWeight = 3

                wpnAccCost = 2
                wpnCritCost = 3
                wpnDmgCost = 6
            }

            "Rapier" -> {
                weaponAttribute = "Dexterity"

                weaponDice = "K8"
                weaponDamage = 2
                weaponCrit = 3
                weaponAccuracy = 7
                weaponWeight = 1

                wpnAccCost = 2
                wpnCritCost = 3
                wpnDmgCost = 5
            }

            "Spear" -> {
                weaponAttribute = "Dexterity"

                weaponDice = "K8"
                weaponDamage = 3
                weaponCrit = 3
                weaponAccuracy = 5
                weaponWeight = 1

                wpnAccCost = 3
                wpnCritCost = 3
                wpnDmgCost = 5
            }

            "Spear(2H)" -> {
                weaponAttribute = "Dexterity/Strength"

                weaponDice = "K10"
                weaponDamage = 3
                weaponCrit = 3
                weaponAccuracy = 5
                weaponWeight = 1

                wpnAccCost = 3
                wpnCritCost = 3
                wpnDmgCost = 6
            }

            "Axe" -> {
                weaponAttribute = "Strength"

                weaponDice = "K10"
                weaponDamage = 2
                weaponCrit = 2
                weaponAccuracy = 8
                weaponWeight = 3

                wpnAccCost = 3
                wpnCritCost = 5
                wpnDmgCost = 6
            }

            "Axe(2H)" -> {
                weaponAttribute = "Strength"

                weaponDice = "K12"
                weaponDamage = 2
                weaponCrit = 2
                weaponAccuracy = 8
                weaponWeight = 3

                wpnAccCost = 3
                wpnCritCost = 5
                wpnDmgCost = 7
            }

            "Hammer" -> {
                weaponAttribute = "Strength"

                weaponDice = "K10"
                weaponDamage = 2
                weaponCrit = 1
                weaponAccuracy = 8
                weaponWeight = 4

                wpnAccCost = 3
                wpnCritCost = 5
                wpnDmgCost = 6
            }

            "Hammer(2H)" -> {
                weaponAttribute = "Strength"

                weaponDice = "K12"
                weaponDamage = 2
                weaponCrit = 1
                weaponAccuracy = 10
                weaponWeight = 4

                wpnAccCost = 3
                wpnCritCost = 5
                wpnDmgCost = 7
            }

            "Halberd" -> {
                weaponDice = "K12"
                weaponDamage = 2
                weaponCrit = 3
                weaponAccuracy = 5
                weaponWeight = 5

                wpnAccCost = 3
                wpnCritCost = 4
                wpnDmgCost = 7
            }

            "Bow" -> {
                weaponDice = "K10"
                weaponDamage = 2
                weaponCrit = 0
                weaponAccuracy = 0
                weaponWeight = 2

                wpnAccCost = 3
                wpnCritCost = 5
                wpnDmgCost = 6
            }

            "Crossbow" -> {
                crossbowDamage = 5
                weaponDice = "K10"
                crossbowReload = 2
                weaponCrit = 3
                weaponAccuracy = 3
                weaponWeight = 3

                wpnAccCost = 3
                wpnCritCost = 5
                wpnDmgCost = 3
            }

            "Magic robes" -> {
                armorDef = 1
                armorMdef = 2
                armorDurability = 2
                armorWeight = 2

                armorDefCost = 3
                armorMdefCost = 2
                armorWeightGain = 2
            }

            "Leather armor" -> {
                armorDef = 2
                armorMdef = 2
                armorDurability = 2
                armorWeight = 1

                armorDefCost = 4
                armorMdefCost = 3
                armorWeightGain = 1
            }

            "Chainmail" -> {
                armorDef = 3
                armorMdef = 1
                armorDurability = 2
                armorWeight = 3

                armorDefCost = 3
                armorMdefCost = 5
                armorWeightGain = 2
            }

            "Plate Armor" -> {
                armorDef = 4
                armorMdef = 0
                armorDurability = 2
                armorWeight = 5

                armorDefCost = 2
                armorMdefCost = 6
                armorWeightGain = 3
            }
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var itemTypeSpinner: Spinner
        var selectedItemSpinner: Spinner

        var meleeNameText: TextView
        var meleeDiceText: TextView
        var meleeAccuractText: TextView
        var meleeCritText: TextView
        var meleeWeightText: TextView
        var levelNeededText: TextView

        var meleePlusStrBtn: Button
        var meleeMinusStrBtn: Button
        var meleePlusCritBtn: Button
        var meleeMinusCritBtn: Button
        var meleePlusAccBtn: Button
        var meleeMinusAccBtn: Button
        var meleeMinusWeightBtn: Button
        var meleePlusWeightBtn: Button

        var armorPlusBtn = findViewById<Button>(R.id.armorPlusBtn)
        var armorMinusBtn = findViewById<Button>(R.id.armorMinusBtn)
        var magicArmorPlusBtn = findViewById<Button>(R.id.magicArmorPlusBtn)
        var magicArmorMinusBtn = findViewById<Button>(R.id.magicArmorMinusBtn)
        var plusDurabilityBtn = findViewById<Button>(R.id.plusDurabilityBtn)
        var minusDurabilityBtn = findViewById<Button>(R.id.minusDurabilityBtn)

        var crossbowPlusDmgBtn = findViewById<Button>(R.id.crossbowPlusDmgBtn)
        var crossbowMinusDmgBtn = findViewById<Button>(R.id.crossbowMinusDmgBtn)
        var crossbowPlusReloadBtn = findViewById<Button>(R.id.crossbowPlusReloadBtn)
        var crossbowMinusReloadBtn = findViewById<Button>(R.id.crossbowMinusReloadBtn)


        var resetBtn: Button

        meleeNameText = findViewById(R.id.meleeNameText)
        meleeDiceText = findViewById(R.id.meleeDiceText)
        meleeAccuractText = findViewById(R.id.meleeAccuracyText)
        meleeCritText = findViewById(R.id.meleeCritText)
        meleeWeightText = findViewById(R.id.meleeWeightText)
        levelNeededText = findViewById(R.id.levelNeeded)

        meleePlusStrBtn = findViewById(R.id.meleePlusStrBtn)
        meleeMinusStrBtn = findViewById(R.id.meleeMinusStrBtn)
        meleePlusCritBtn = findViewById(R.id.meleePlusCritBtn)
        meleeMinusCritBtn = findViewById(R.id.meleeMinusCritBtn)
        meleePlusAccBtn = findViewById(R.id.meleePlusAccBtn)
        meleeMinusAccBtn = findViewById(R.id.meleeMinusAccBtn)
        meleePlusWeightBtn = findViewById(R.id.meleePlusWeightBtn)
        meleeMinusWeightBtn = findViewById(R.id.meleeMinusWeightBtn)

        resetBtn = findViewById(R.id.resetBtn)

        itemTypeSpinner = findViewById(R.id.itemTypeSpinner)
        selectedItemSpinner = findViewById(R.id.selectedItemSpinner)


        fun meleeWindowViewVisibility() {
            meleeDiceText.visibility = View.VISIBLE
            meleeAccuractText.visibility = View.VISIBLE
            meleeCritText.visibility = View.VISIBLE
            crossbowDmgText.visibility = View.GONE
            reloadText.visibility = View.GONE
            armorValueText.visibility = View.GONE
            magicArmorValueText.visibility = View.GONE
            durabilityText.visibility = View.GONE

            meleePlusStrBtn.visibility = View.VISIBLE
            meleeMinusStrBtn.visibility = View.VISIBLE
            meleePlusCritBtn.visibility = View.VISIBLE
            meleeMinusCritBtn.visibility = View.VISIBLE
            meleePlusAccBtn.visibility = View.VISIBLE
            meleeMinusAccBtn.visibility = View.VISIBLE
            armorPlusBtn.visibility = View.GONE
            armorMinusBtn.visibility = View.GONE
            magicArmorPlusBtn.visibility = View.GONE
            magicArmorMinusBtn.visibility = View.GONE
            plusDurabilityBtn.visibility = View.GONE
            minusDurabilityBtn.visibility = View.GONE
            crossbowPlusDmgBtn.visibility = View.GONE
            crossbowMinusDmgBtn.visibility = View.GONE
            crossbowPlusReloadBtn.visibility = View.GONE
            crossbowMinusReloadBtn.visibility = View.GONE
        }

        fun crossbowWindowViewVisibility() {
            meleeDiceText.visibility = View.VISIBLE
            meleeAccuractText.visibility = View.VISIBLE
            meleeCritText.visibility = View.VISIBLE
            crossbowDmgText.visibility = View.VISIBLE
            reloadText.visibility = View.VISIBLE
            armorValueText.visibility = View.GONE
            magicArmorValueText.visibility = View.GONE
            durabilityText.visibility = View.GONE

            meleePlusStrBtn.visibility = View.GONE
            meleeMinusStrBtn.visibility = View.GONE
            meleePlusCritBtn.visibility = View.VISIBLE
            meleeMinusCritBtn.visibility = View.VISIBLE
            meleeMinusAccBtn.visibility = View.VISIBLE
            meleePlusAccBtn.visibility = View.VISIBLE
            armorPlusBtn.visibility = View.GONE
            armorMinusBtn.visibility = View.GONE
            magicArmorPlusBtn.visibility = View.GONE
            magicArmorMinusBtn.visibility = View.GONE
            plusDurabilityBtn.visibility = View.GONE
            minusDurabilityBtn.visibility = View.GONE
            crossbowPlusDmgBtn.visibility = View.VISIBLE
            crossbowMinusDmgBtn.visibility = View.VISIBLE
            crossbowPlusReloadBtn.visibility = View.VISIBLE
            crossbowMinusReloadBtn.visibility = View.VISIBLE
        }

        fun armorWindowViewVisibility() {
            meleeDiceText.visibility = View.GONE
            meleeAccuractText.visibility = View.GONE
            meleeCritText.visibility = View.GONE
            crossbowDmgText.visibility = View.GONE
            reloadText.visibility = View.GONE
            armorValueText.visibility = View.VISIBLE
            magicArmorValueText.visibility = View.VISIBLE
            durabilityText.visibility = View.VISIBLE

            meleePlusStrBtn.visibility = View.GONE
            meleeMinusStrBtn.visibility = View.GONE
            meleePlusCritBtn.visibility = View.GONE
            meleeMinusCritBtn.visibility = View.GONE
            meleeMinusAccBtn.visibility = View.GONE
            meleePlusAccBtn.visibility = View.GONE
            armorPlusBtn.visibility = View.VISIBLE
            armorMinusBtn.visibility = View.VISIBLE
            magicArmorPlusBtn.visibility = View.VISIBLE
            magicArmorMinusBtn.visibility = View.VISIBLE
            plusDurabilityBtn.visibility = View.VISIBLE
            minusDurabilityBtn.visibility = View.VISIBLE
            crossbowPlusDmgBtn.visibility = View.GONE
            crossbowMinusDmgBtn.visibility = View.GONE
            crossbowPlusReloadBtn.visibility = View.GONE
            crossbowMinusReloadBtn.visibility = View.GONE
        }

        fun setMeleeWindowText() {
            meleeNameText.setText(itemVar)
            meleeDiceText.setText("Dice: $weaponDamage$weaponDice")
            meleeAccuractText.setText("Accuracy: +$weaponAccuracy")
            meleeCritText.setText("Critical: +$weaponCrit")
            meleeWeightText.setText("Weight: $weaponWeight")
            levelNeededText.setText("Item's level: $level")
        }

        fun setArmorWindowText() {
            meleeNameText.setText(itemVar)
            armorValueText.setText("Armor: $armorDef")
            magicArmorValueText.setText("MAgic armor: $armorMdef")
            durabilityText.setText("Durability: $armorDurability")
            meleeWeightText.setText("Weight: $weaponWeight")
            levelNeededText.setText("Item's level: $level")
        }

        fun setCrossbowWindowText() {
            meleeNameText.setText(itemVar)
            crossbowDmgText.setText("Damage: $crossbowDamage")
            reloadText.setText("Reload: $crossbowReload")
            meleeAccuractText.setText("Accuracy: +$weaponAccuracy")
            meleeCritText.setText("Critical: +$weaponCrit")
            meleeDiceText.setText("K10")
            meleeWeightText.setText("Weight: $weaponWeight")
            levelNeededText.setText("Item's level: $level")
        }


        var types = arrayOf("Melee weapons", "Ranged weapons", "Armor")

        var meleeWeapons = arrayOf(
            "Dagger", "Staff", "Sabre", "Sword", "Sword(2H)",
            "Katana", "Katana(2H)", "Rapier", "Spear", "Spear(2H)", "Axe", "Axe(2H)", "Hammer", "Hammer(2H)", "Halberd"
        )

        var rangedWeapons = arrayOf("Bow", "Crossbow")

        var armorTypes = arrayOf("Magic Robes", "Leather Armor", "Chainmail", "Plate Armor")


        itemTypeSpinner.adapter = ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, types)
        selectedItemSpinner.adapter =
            ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, meleeWeapons)


        itemTypeSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                typeVar = "Melee weapons"
                types.set(1, "Melee weapons")
                meleeWindowViewVisibility()
                setMeleeWindowText()
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                typeVar = types.get(position)

                if (typeVar == "Melee weapons") {
                    selectedItemSpinner.adapter = ArrayAdapter<String>(
                        this@MainActivity,
                        android.R.layout.simple_expandable_list_item_1,
                        meleeWeapons
                    )
                    setMeleeWindowText()
                    meleeWindowViewVisibility()
                } else if (typeVar == "Ranged weapons") {
                    selectedItemSpinner.adapter = ArrayAdapter<String>(
                        this@MainActivity,
                        android.R.layout.simple_expandable_list_item_1,
                        rangedWeapons
                    )
                    meleeWindowViewVisibility()
                    setMeleeWindowText()

                } else if (typeVar == "Armor") {
                    selectedItemSpinner.adapter = ArrayAdapter<String>(
                        this@MainActivity,
                        android.R.layout.simple_expandable_list_item_1,
                        armorTypes
                    )
                    armorWindowViewVisibility()
                    setArmorWindowText()
                }
            }
        }


        selectedItemSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onNothingSelected(parent: AdapterView<*>?) {
                itemVar = "Dagger"
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

                if (typeVar == "Melee weapons") {
                    itemVar = meleeWeapons.get(position)

                    assignParameters()

                    level = 1

                    setMeleeWindowText()

                    meleePlusStrBtn.setText("+1 $weaponDice, +${wpnDmgCost - 3} Weight, +$wpnDmgCost LVL")
                    meleeMinusStrBtn.setText("-1 $weaponDice, -${wpnDmgCost - 3} Weight, -$wpnDmgCost LVL")
                    meleePlusAccBtn.setText("+1 Accuracy, +$wpnAccCost LVL")
                    meleeMinusAccBtn.setText("-1 Accuracy, -$wpnAccCost LVL")
                    meleePlusCritBtn.setText("+1 Crit, -2 Accuracy, +$wpnCritCost LVL")
                    meleeMinusCritBtn.setText("-1 Crit, +2 Accuracy -$wpnCritCost LVL")
                    meleePlusWeightBtn.setText("+1 Weight, -2 LVL")
                    meleeMinusWeightBtn.setText("-1 Weight, +2 LVL")

                    meleePlusStrBtn.setOnClickListener {
                        weaponDamage = weaponDamage + 1
                        weaponWeight = weaponWeight + (wpnDmgCost - 3)
                        level = level + wpnDmgCost
                        setMeleeWindowText()
                    }

                    meleeMinusStrBtn.setOnClickListener {
                        level = level - wpnDmgCost

                        if (level > 0) {
                            weaponDamage = weaponDamage - 1
                            weaponWeight = weaponWeight - (wpnDmgCost - 3)
                            setMeleeWindowText()
                        } else {
                            level = level + wpnDmgCost
                            toast("Item's level cannot be lower than 0")
                        }
                    }

                    meleePlusAccBtn.setOnClickListener {
                        weaponAccuracy = weaponAccuracy + 1
                        level = level + wpnAccCost
                        setMeleeWindowText()
                    }

                    meleeMinusAccBtn.setOnClickListener {
                        level = level - wpnAccCost
                        if (level > 0) {
                            weaponAccuracy = weaponAccuracy - 1
                            setMeleeWindowText()
                        } else {
                            level = level + wpnAccCost
                            toast("Item's level cannot be lower than 0")
                        }


                    }

                    meleePlusCritBtn.setOnClickListener {
                        weaponCrit = weaponCrit + 1
                        weaponAccuracy = weaponAccuracy - 2
                        level = level + wpnCritCost
                        setMeleeWindowText()
                    }

                    meleeMinusCritBtn.setOnClickListener {
                        level = level - wpnCritCost
                        if (level > 0) {
                            weaponCrit = weaponCrit - 1
                            weaponAccuracy = weaponAccuracy + 2
                            setMeleeWindowText()
                        } else {
                            level = level + wpnCritCost
                            toast("Item's level cannot be lower than 0")
                        }

                    }

                    resetBtn.setOnClickListener {
                        assignParameters()
                        setMeleeWindowText()
                    }

                }
                else if (typeVar == "Ranged weapons") {

                    itemVar = rangedWeapons.get(position)

                    level = 1

                    assignParameters()

                    meleePlusStrBtn.setText("+1 $weaponDice, +${wpnDmgCost - 3} Weight, +$wpnDmgCost LVL")
                    meleeMinusStrBtn.setText("-1 $weaponDice, -${wpnDmgCost - 3} Weight, -$wpnDmgCost LVL")
                    meleePlusAccBtn.setText("+1 Accuracy, +$wpnAccCost LVL")
                    meleeMinusAccBtn.setText("-1 Accuracy, -$wpnAccCost LVL")
                    meleePlusCritBtn.setText("+1 Crit, -2 Accuracy, +$wpnCritCost LVL")
                    meleeMinusCritBtn.setText("-1 Crit, +2 Accuracy -$wpnCritCost LVL")
                    meleePlusWeightBtn.setText("+1 Weight, -2 LVL")
                    meleeMinusWeightBtn.setText("-1 Weight, +2 LVL")
                    crossbowPlusDmgBtn.setText("+2 Damage, +1 Reload, +1 Weight, +3 LVL")
                    crossbowMinusDmgBtn.setText("-2 Damage, -1 Reload, -1 Weight, -3 LVL")
                    crossbowMinusReloadBtn.setText("-1 Reload, +2 LVL")
                    crossbowPlusReloadBtn.setText("+1 Reload, -2 LVL")

                    if (itemVar == "Crossbow") {
                        crossbowWindowViewVisibility()
                        setCrossbowWindowText()

                        crossbowPlusDmgBtn.setOnClickListener {
                            level = level + crossbowDmgCost
                            crossbowDamage = crossbowDamage + 2
                            weaponWeight = weaponWeight + 1
                            crossbowReload = crossbowReload + 1
                            setCrossbowWindowText()

                            crossbowMinusDmgBtn.setOnClickListener {
                                level = level - crossbowDmgCost
                                if (level > 0) {
                                    crossbowDamage = crossbowDamage + 2
                                    weaponWeight = weaponWeight + 1
                                    crossbowReload = crossbowReload + 1
                                    setCrossbowWindowText()
                                } else {
                                    level = level + crossbowDmgCost
                                    toast("Item's level cannot be lower than 0")
                                }
                            }

                            crossbowMinusReloadBtn.setOnClickListener {
                                level = level + 2
                                crossbowReload = crossbowReload - 1
                            }

                            crossbowPlusReloadBtn.setOnClickListener {
                                level = level - 2
                                if (level > 0) {
                                    crossbowReload = crossbowReload + 1
                                    setCrossbowWindowText()
                                } else {
                                    level = level + 2
                                    toast("Item's level cannot be lower than 0")
                                }
                            }

                            meleePlusAccBtn.setOnClickListener {
                                weaponAccuracy = weaponAccuracy + 1
                                level = level + wpnAccCost

                                setCrossbowWindowText()
                            }
                            meleeMinusAccBtn.setOnClickListener {
                                level = level - wpnAccCost
                                if (level > 0) {
                                    weaponAccuracy = weaponAccuracy - 1
                                    setCrossbowWindowText()
                                } else {
                                    level = level + wpnAccCost
                                    toast("Item's level cannot be lower than 0")
                                }
                            }
                            meleePlusCritBtn.setOnClickListener {
                                weaponCrit = weaponCrit + 1
                                weaponAccuracy = weaponAccuracy - 2
                                level = level + wpnCritCost
                                setCrossbowWindowText()
                            }
                            meleeMinusCritBtn.setOnClickListener {
                                level = level - wpnCritCost
                                if (level > 0) {
                                    weaponCrit = weaponCrit - 1
                                    weaponAccuracy = weaponAccuracy + 2
                                    setCrossbowWindowText()
                                } else {
                                    level = level + wpnCritCost
                                    toast("Item's level cannot be lower than 0")
                                }
                            }

                            meleePlusWeightBtn.setOnClickListener {
                                weaponWeight = weaponWeight + 1
                                level = level - 2

                                if (level > 0) {
                                    setCrossbowWindowText()
                                } else {
                                    level = level + 2
                                    weaponWeight - 1
                                    toast("Item's level cannot be lower than 0")
                                }
                            }
                            meleeMinusWeightBtn.setOnClickListener {
                                weaponWeight = weaponWeight - 1
                                level = level + 2

                                if (weaponWeight < 0) {
                                    level = level - 2
                                    weaponWeight = weaponWeight + 1
                                    toast("Item's weight cannot be lower than 0")
                                } else {
                                    setCrossbowWindowText()
                                }
                            }
                            resetBtn.setOnClickListener {
                                assignParameters()
                                setCrossbowWindowText()
                            }

                        }
                    } else {
                        meleeWindowViewVisibility()
                        setMeleeWindowText()

                        meleePlusStrBtn.setOnClickListener {
                            weaponDamage = weaponDamage + 1
                            weaponWeight = weaponWeight + (wpnDmgCost - 3)
                            level = level + wpnDmgCost
                            setMeleeWindowText()
                        }
                        meleeMinusStrBtn.setOnClickListener {
                            level = level - wpnDmgCost

                            if (level > 0) {
                                weaponDamage = weaponDamage - 1
                                weaponWeight = weaponWeight - (wpnDmgCost - 3)
                                setMeleeWindowText()
                            } else {
                                level = level + wpnDmgCost
                                toast("Item's level cannot be lower than 0")
                            }
                        }

                        meleePlusAccBtn.setOnClickListener {
                            weaponAccuracy = weaponAccuracy + 1
                            level = level + wpnAccCost

                            setMeleeWindowText()
                        }

                        meleeMinusAccBtn.setOnClickListener {
                            level = level - wpnAccCost
                            if (level > 0) {
                                weaponAccuracy = weaponAccuracy - 1
                                setMeleeWindowText()
                            } else {
                                level = level + wpnAccCost
                                toast("Item's level cannot be lower than 0")
                            }
                        }

                        meleePlusCritBtn.setOnClickListener {
                            weaponCrit = weaponCrit + 1
                            weaponAccuracy = weaponAccuracy - 2
                            level = level + wpnCritCost
                            setMeleeWindowText()
                        }

                        meleeMinusCritBtn.setOnClickListener {
                            level = level - wpnCritCost
                            if (level > 0) {
                                weaponCrit = weaponCrit - 1
                                weaponAccuracy = weaponAccuracy + 2
                                setMeleeWindowText()
                            } else {
                                level = level + wpnCritCost
                                toast("Item's level cannot be lower than 0")
                            }

                        }

                        meleePlusWeightBtn.setOnClickListener {
                            weaponWeight = weaponWeight + 1
                            level = level - 2

                            if (level > 0) {
                                setMeleeWindowText()
                            } else {
                                level = level + 2
                                weaponWeight - 1
                                toast("Item's level cannot be lower than 0")
                            }
                        }

                        meleeMinusWeightBtn.setOnClickListener {
                            weaponWeight = weaponWeight - 1
                            level = level + 2

                            if (weaponWeight < 0) {
                                level = level - 2
                                weaponWeight = weaponWeight + 1
                                toast("Item's weight cannot be lower than 0")
                            } else {
                                setMeleeWindowText()
                            }
                        }

                        resetBtn.setOnClickListener {
                            assignParameters()
                            setMeleeWindowText()
                        }

                    }

                }
                else if (typeVar == "Armor") {
                    itemVar = armorTypes.get(position)
                    assignParameters()
                    level = 1
                    setArmorWindowText()

                    armorPlusBtn.setText("+1 Armor, +$armorWeightGain Weight, +$armorDefCost LVL")
                    armorMinusBtn.setText("-1 Armor, -$armorWeightGain Weight, -$armorDefCost LVL")
                    magicArmorPlusBtn.setText("+1 Magic Armor, +$armorWeightGain Weight, +$armorMdefCost LVL")
                    magicArmorMinusBtn.setText("-1 Magic Armor, -$armorWeightGain Weight, -$armorMdefCost LVL")
                    plusDurabilityBtn.setText("+1 Durability, +$armorDurability Weight, +3 LVL")
                    minusDurabilityBtn.setText("+1 Durability, +$armorDurability Weight, +3 LVL")


                    armorPlusBtn.setOnClickListener {
                        armorDef += 1
                        level += armorDefCost
                        armorWeight += armorWeightGain

                        setArmorWindowText()

                    }
                    armorMinusBtn.setOnClickListener {
                        level -= armorDefCost
                        if (level > 0) {
                            armorWeight += armorWeightGain
                            armorDef += 1
                            setArmorWindowText()
                        } else {
                            level = level + armorDefCost
                            toast("Item's level cannot be lower than 1")
                        }
                    }
                        magicArmorPlusBtn.setOnClickListener {
                            armorMdef += 1
                            level += armorMdefCost
                            armorWeight += armorWeightGain

                            setArmorWindowText()
                        }
                        magicArmorMinusBtn.setOnClickListener {
                            level -= armorMdefCost
                            if (level > 0) {
                                armorWeight += armorWeightGain
                                armorMdef += 1
                                setArmorWindowText()
                            } else {
                                level = level + armorMdefCost
                                toast("Item's level cannot be lower than 1")
                            }
                        }
                        plusDurabilityBtn.setOnClickListener {
                            level += 3
                            armorWeight += armorDurability
                            armorDurability += 1
                            setArmorWindowText()
                        }
                        minusDurabilityBtn.setOnClickListener {
                            level -= 3
                            if (level > 0) {
                                armorDurability -= 1
                                armorWeight -= armorDurability
                                setArmorWindowText()
                            }else{
                                level = level + 3
                                toast("Item's level cannot be lower than 1")
                            }

                        }


                        meleePlusWeightBtn.setOnClickListener {
                            weaponWeight = weaponWeight + 1
                            level = level - 2

                            if (level > 0) {
                                setArmorWindowText()
                            } else {
                                level = level + 2
                                weaponWeight - 1
                                toast("Item's level cannot be lower than 0")
                            }
                        }
                        meleeMinusWeightBtn.setOnClickListener {
                            weaponWeight = weaponWeight - 1
                            level = level + 2

                            if (weaponWeight < 0) {
                                level = level - 2
                                weaponWeight = weaponWeight + 1
                                toast("Item's weight cannot be lower than 0")
                            } else {
                                setArmorWindowText()
                            }
                        }

                        resetBtn.setOnClickListener {
                            assignParameters()
                            setArmorWindowText()
                        }

                    }
                }
            }

        }

    }

